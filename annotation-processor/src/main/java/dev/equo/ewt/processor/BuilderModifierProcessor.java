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
import java.util.Set;


@AutoService(Processor.class)
@SupportedAnnotationTypes({"org.immutables.builder.Builder.Factory", "org.immutables.value.Generated"})
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class BuilderModifierProcessor extends AbstractProcessor {

  private TypeElement aBuilderInterface;
  private Set<String> created = new HashSet<>();

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    System.err.println("BuilderModifierProcessor.init");
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    System.err.println("BuilderModifierProcessor.process " + annotations);

//    TypeElement anno = processingEnv.getElementUtils().getTypeElement("org.immutables.builder.Builder.Factory");
//    System.err.println(anno);
//    for (Element el : roundEnv.getElementsAnnotatedWith(anno)) {
//      System.err.println("Factory: " + el.getSimpleName());

//      TypeElement widgetClass = (TypeElement) el.getEnclosingElement();
//      writeInterface(widgetClass);
//    }

    TypeElement genAnno = processingEnv.getElementUtils().getTypeElement("org.immutables.value.Generated");
    for (Element el : roundEnv.getElementsAnnotatedWith(genAnno)) {
      //String builderName = "dev.equo.ewt." + el.getSimpleName().toString().substring(0, 1).toUpperCase() + el.getSimpleName().toString().substring(1) + "Builder";
      //System.err.println("finding: " + builderName);
//      TypeElement builderTypeEl = processingEnv.getElementUtils().getTypeElement(builderName);
      TypeElement builderTypeEl = (TypeElement) el;
//      if (builderTypeEl != null) {
//        System.err.println("Found "+builderName);
        if (builderTypeEl.getInterfaces().isEmpty()) {
//          TypeElement widgetClass = (TypeElement) el.getEnclosingElement();
          String widgetClass = builderTypeEl.getEnclosedElements().stream().filter(m -> "build".equals(m.getSimpleName().toString())).map(ExecutableElement.class::cast).map(ExecutableElement::getReturnType).map(TypeMirror::toString).findFirst().get();
          String widgetIName = widgetClass + "I";
          try {
            JavaFileObject fileObj = processingEnv.getElementUtils().getFileObjectOf(builderTypeEl);
            String content = fileObj.getCharContent(true).toString();
            String modifiedSource = content.replace("Builder {", "Builder implements "+widgetIName+" {");
            processingEnv.getMessager().printNote("Modifying "+el.getSimpleName());
            try (Writer writer = fileObj.openWriter()) {
              writer.write(modifiedSource);
            }
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        }
      }
//    roundEnv.getRootElements().forEach(c -> System.err.println(c));

    return false;
  }

  private void writeInterface(TypeElement widgetClass) {
    String widgetName = widgetClass.getSimpleName().toString();
    String widgetIName = widgetName + "I";
    if (!created.contains(widgetIName)) {
      try {
        created.add(widgetIName);
        JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile("dev.equo.ewt."+widgetIName, widgetClass);
        TypeMirror superclass = widgetClass.getSuperclass();
        Element superEl = processingEnv.getTypeUtils().asElement(superclass);
        if (superEl.getSimpleName().toString().equals("Base") || superEl.getSimpleName().toString().equals("NativeObj"))
          superEl = null;
        try (Writer writer = sourceFile.openWriter()) {
          processingEnv.getMessager().printNote("Writing " + widgetIName);
          String extend = (superEl != null) ? " extends " + superEl.getSimpleName() + "I" : " extends " +"NativeObj.I<"+widgetName+">";
          writer.write("package dev.equo.ewt;\n" +
              "interface " + widgetIName + extend+" {}");
        }
        if (superEl != null)
          writeInterface((TypeElement) superEl);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}