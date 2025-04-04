package dev.equo.ewt.processor;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AutoService(Processor.class)
@SupportedAnnotationTypes({/*"org.immutables.builder.Builder.Factory",*/ "org.immutables.value.Generated"})
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class BuilderModifierProcessor extends AbstractProcessor {

  private TypeElement widgetEl;
  private TypeElement genAnno;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    widgetEl = processingEnv.getElementUtils().getTypeElement("dev.equo.ewt.Widget");
    genAnno = processingEnv.getElementUtils().getTypeElement("org.immutables.value.Generated");
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element el : roundEnv.getElementsAnnotatedWith(genAnno)) {
      TypeElement builderTypeEl = (TypeElement) el;
      if (builderTypeEl.getInterfaces().isEmpty()) {
        TypeMirror widgetClass = builderTypeEl.getEnclosedElements().stream()
            .filter(m -> "build".equals(m.getSimpleName().toString()))
            .map(ExecutableElement.class::cast)
            .map(ExecutableElement::getReturnType).findFirst().get();
        String widgetIName = widgetClass + "I";
        boolean isWidget = processingEnv.getTypeUtils().isSubtype(widgetClass, widgetEl.asType());
        String extend = isWidget ? "extends Widget" : "";
        try {
          JavaFileObject fileObj = processingEnv.getElementUtils().getFileObjectOf(builderTypeEl);
          String content = fileObj.getCharContent(true).toString();
          String modifiedSource = content.replace("Builder {", "Builder "+extend+" implements " + widgetIName + " {");
          processingEnv.getMessager().printNote("Modifying " + el.getSimpleName());
          try (Writer writer = fileObj.openWriter()) {
            writer.write(modifiedSource);
          }
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }

    return annotations.stream().anyMatch(a -> a.getQualifiedName().toString().equals("org.immutables.value.Generated"));
  }

}