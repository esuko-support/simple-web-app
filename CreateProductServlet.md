## CreateProductServlet.java は、Webアプリケーションにおいて「商品作成画面を表示する」ためのサーブレットクラスです
## クラスの全体像
- 機能： JSP画面 (createProductView.jsp) をブラウザに表示する
- 場所： servlet/ パッケージ → 「コントローラー層」に相当
- Servlet： クライアントからのリクエスト（HTTP GET/POST）を処理

## syntax
package com.lanihuang.simplewebapp.servlet;このファイルの論理的な所属先（Javaの名前空間）
- servlet は MVCモデルでいう「C（Controller）」層をまとめる場所
- src/com/lanihuang/simplewebapp/servlet/ はパッケージに対応するディレクトリ構造

@WebServlet(urlPatterns = { "/createProduct" })
- このサーブレットが /createProduct というURLでアクセスされることを定義。たとえばブラウザから http://localhost:8080/yourapp/createProduct にアクセスされると、このサーブレットが動作

public class CreateProductServlet extends HttpServlet
- Javaの HttpServlet を継承し、HTTPリクエストを処理できるようにする
- HttpServlet は Java EE（Jakarta EE）における 標準的なサーブレットの親クラス
