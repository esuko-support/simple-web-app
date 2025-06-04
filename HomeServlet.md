## HomeServlet.java は、アプリケーションのホーム画面（トップページ）を表示するだけのサーブレットです。非常に基本的で典型的な構成です

- 📌 クラス名	HomeServlet
- 🏷️ URLパターン	/home でアクセス
- 🖥 表示内容	homeView.jsp を画面に表示
- 📚 役割	**Controller層（MVCにおけるC）**として、ユーザーにViewを返すための橋渡し

## systax

🧩 処理フロー
ブラウザが /home にアクセスする（HTTPリクエスト）
HomeServlet.doGet() が呼び出される
RequestDispatcher により、homeView.jsp へ画面遷移（フォワード）

<pre>
RequestDispatcher dispatcher = this.getServletContext()
    .getRequestDispatcher("/WEB-INF/views/homeView.jsp");
dispatcher.forward(request, response);
</pre>
-WEB-INF 配下の JSP は 直接アクセス不可（セキュリティ目的）そのため Servletが中継して表示する

🔁 POST対応について
<pre>
@Override
protected void doPost(...) {
  doGet(...);
}
</pre>
- POSTでアクセスされた場合でも、GETと同じ画面表示処理にする（共通化）
- ログイン直後のリダイレクト先などで POST が来るケースを想定

