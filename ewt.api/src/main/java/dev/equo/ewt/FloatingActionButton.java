package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class FloatingActionButton extends StatelessWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  FloatingActionButton() {}
  FloatingActionButton(int id) {
    this.id = id;
  }
}
