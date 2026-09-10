# Java Streamlit Demo

Javaだけを中心に、Streamlit風の小さなWebアプリを作るサンプルです。

- Java 21
- Spring Boot 4.1.1
- Vaadin 25.2.7
- Maven
- Docker
- Render対応 (`render.yaml`)

## 1. Eclipseで開く

1. Eclipseを起動
2. `File` → `Import...`
3. `Maven` → `Existing Maven Projects`
4. このフォルダを選択
5. `pom.xml` が検出されたら `Finish`

Java 21をEclipseで使用してください。

## 2. ローカル起動

ターミナルで:

```bash
mvn spring-boot:run
```

ブラウザで:

```text
http://localhost:8080
```

または Eclipse で `Application.java` を右クリックし、
`Run As` → `Java Application` でも起動できます。

## 3. GitHubへ置く

GitHubで空のリポジトリを作成してから、このプロジェクトのディレクトリで:

```bash
git init
git add .
git commit -m "Initial Java Vaadin app"
git branch -M main
git remote add origin https://github.com/YOUR_NAME/java-streamlit-demo.git
git push -u origin main
```

`YOUR_NAME` は自分のGitHubユーザー名に置き換えてください。

## 4. RenderでWeb公開

このリポジトリには `Dockerfile` と `render.yaml` が含まれています。

RenderでGitHubアカウントを接続し、このリポジトリから Web Service / Blueprint を作成します。
`render.yaml` は無料Web Serviceプランを指定しています。

Render側でビルドが完了すると、公開URLからアクセスできます。

## 5. Streamlitとの対応イメージ

Python / Streamlit:

```python
name = st.text_input("名前")
if st.button("実行"):
    st.write("こんにちは", name)
```

Java / Vaadin:

```java
TextField name = new TextField("名前");
Button button = new Button("実行");
Span result = new Span();

button.addClickListener(e ->
    result.setText("こんにちは " + name.getValue())
);

add(name, button, result);
```

## 6. オンラインデモ
https://java-streamlit-demo.onrender.com/

## 次に追加しやすい機能

- URL入力 → Seleniumでスクリーンショット取得
- SQLite / PostgreSQLへの保存
- CSVアップロード・一覧表示
- ファイルアップロード
- Javaで画像処理
- REST API呼び出し
- ログイン機能
- GitHub push時の自動デプロイ


## Vaadin 25 development mode note

This project keeps `com.vaadin:vaadin-dev` in an active-by-default Maven `development` profile.
Run locally with:

```bash
mvn clean spring-boot:run
```

You can verify the development server dependency is present with:

```bash
mvn dependency:tree -Dincludes=com.vaadin:vaadin-dev,com.vaadin:vaadin-dev-server
```

For a production frontend build, use:

```bash
mvn clean package -Pproduction
```
