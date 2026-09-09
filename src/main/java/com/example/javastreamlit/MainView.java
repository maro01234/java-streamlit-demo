package com.example.javastreamlit;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Java Streamlit Demo")
public class MainView extends VerticalLayout {

    private final TextField name = new TextField("名前");
    private final IntegerField repeat = new IntegerField("繰り返し回数");
    private final TextArea memo = new TextArea("メモ");
    private final Span result = new Span();

    public MainView() {
        setMaxWidth("760px");
        setWidthFull();
        setMargin(true);
        setSpacing(true);

        H1 title = new H1("Java Streamlit Demo");
        Paragraph intro = new Paragraph(
                "PythonのStreamlitのように、Javaコード中心で入力UIと結果表示を作る最小サンプルです。"
        );

        name.setPlaceholder("例: Hiroshi");
        name.setWidthFull();

        repeat.setMin(1);
        repeat.setMax(10);
        repeat.setValue(1);
        repeat.setStepButtonsVisible(true);

        memo.setPlaceholder("自由にメモを入力してください");
        memo.setWidthFull();
        memo.setMinHeight("120px");

        Button runButton = new Button("実行", event -> runApp());
        runButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button clearButton = new Button("クリア", event -> clearForm());

        HorizontalLayout buttons = new HorizontalLayout(runButton, clearButton);

        result.getStyle()
                .set("display", "block")
                .set("white-space", "pre-wrap")
                .set("padding", "1rem")
                .set("border", "1px solid var(--lumo-contrast-20pct)")
                .set("border-radius", "var(--lumo-border-radius-m)")
                .set("min-height", "3rem");
        result.setWidthFull();
        result.setText("ここに結果が表示されます。");

        add(title, intro, name, repeat, memo, buttons, result);
    }

    private void runApp() {
        String userName = name.getValue().isBlank() ? "ゲスト" : name.getValue().trim();
        int count = repeat.getValue() == null ? 1 : repeat.getValue();
        String note = memo.getValue().isBlank() ? "（メモなし）" : memo.getValue().trim();

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            output.append(i)
                    .append(". こんにちは、")
                    .append(userName)
                    .append("さん！\n");
        }
        output.append("\nメモ: ").append(note);

        result.setText(output.toString());
    }

    private void clearForm() {
        name.clear();
        repeat.setValue(1);
        memo.clear();
        result.setText("ここに結果が表示されます。");
    }
}
