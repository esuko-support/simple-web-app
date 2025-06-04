## DoCreateProductServlet.java は、**商品登録フォームから送信されたデータを処理し、DBに登録する機能を持つサーブレット（コントローラー）**です

項目/説明
- 📌 クラス名	DoCreateProductServlet
- 🔁 処理内容	POST（あるいは GET）された商品情報をDBに登録する
- 📥 URLパス	/doCreateProduct
- 🔁 ビジネスロジック	DBUtils.insertProduct() を呼び出して登録処理
- 📤 処理結果	成功 → 商品一覧画面へリダイレクト／失敗 → 登録画面へ戻る（エラーメッセージ付き

<pre>
String code = (String) request.getParameter("code");
String name = (String) request.getParameter("name");
String priceStr = (String) request.getParameter("price");
<pre/>
