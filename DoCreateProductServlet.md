## DoCreateProductServlet.java は、**商品登録フォームから送信されたデータを処理し、DBに登録する機能を持つサーブレット（コントローラー）**です

項目/説明
- 📌 クラス名	DoCreateProductServlet
- 🔁 処理内容	POST（あるいは GET）された商品情報をDBに登録する
- 📥 URLパス	/doCreateProduct
- 🔁 ビジネスロジック	DBUtils.insertProduct() を呼び出して登録処理
- 📤 処理結果	成功 → 商品一覧画面へリダイレクト／失敗 → 登録画面へ戻る（エラーメッセージ付き

## syntax
1 入力値の取得
<pre>
String code = (String) request.getParameter("code");
String name = (String) request.getParameter("name");
String priceStr = (String) request.getParameter("price");
<pre/>
- HTMLフォームから送られた商品コード・名前・価格を取得

2 型変換
<pre>
float price = 0;
try {
  price = Float.parseFloat(priceStr);
} catch (Exception e) {
}
<pre/>
- price は文字列で送られてくるので、float に変換
- 数値以外が入っていても落ちないよう、try-catch で例外処理

3 バリデーション（入力検証）
<pre>
String regex = "\\w+";
if (code == null || !code.matches(regex)) {
  errorString = "Product Code invalid!";
}
<pre/>
- 商品コードが「英数字＋_」で構成されるかチェック
- 条件に合わなければ errorString にエラーを格納

4 DB登録
<pre>
if (errorString == null) {
  try {
    DBUtils.insertProduct(conn, product);
  } catch (SQLException e) {
    errorString = e.getMessage();
  }
}
<pre/>
- エラーがない場合は、DBUtils.insertProduct() を通じてDBに挿入
- SQLException の発生に備えてエラーハンドリング

5 画面遷移・レスポンスの切り替え
<pre>
if (errorString != null) {
  // エラー時：元の入力画面に戻る
  dispatcher.forward(request, response);
} else {
  // 成功時：商品一覧へリダイレクト
  response.sendRedirect(request.getContextPath() + "/productList");
}
処理が成功 → 一覧画面へリダイレクト
<pre/>
 -処理が失敗 → エラー情報を持ったまま、入力画面に戻す
