## CreateProductServlet.java は、Webアプリケーションにおいて「商品作成画面を表示する」ためのサーブレットクラスです
## クラスの全体像
- 機能： JSP画面 (createProductView.jsp) をブラウザに表示する
- 場所： servlet/ パッケージ → 「コントローラー層」に相当
- Servlet： クライアントからのリクエスト（HTTP GET/POST）を処理

## syntax

package com.lanihuang.simplewebapp.servlet;
- このファイルの論理的な所属先（Javaの名前空間）
- servlet は MVCモデルでいう「C（Controller）」層をまとめる場所
- src/com/lanihuang/simplewebapp/servlet/ はパッケージに対応するディレクトリ構造
