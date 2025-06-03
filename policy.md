##ステップ	内容	理解の軸

## コア構成の把握	Servlet ⇄ DBUtils ⇄ Connection	呼び出し順／責任分離
  -用語解説：「コア (core)」
  -意味：英語の「core」は「中心」「核」「基盤」といった意味です。
  -この場での使い方：
  -アプリケーション全体の処理の中心的な流れや構成のことを指します。
  -つまり、このアプリが何をするために、どのクラスや機能がどう繋がって動くのかを表すものです。

## データ構造の把握	Product クラスなどのBean定義	データの形（値オブジェクト）

## 画面連携の流れ	JSP, web.xml, request.setAttribute()	Viewの動き・渡すデータ

## 共通処理の役割	MyUtils, Filter, conn.*	繰り返し使われる部品たち

## 例外処理／セキュリティ	try-catch, rollback, web.xml制御	安定性と安全性の仕組み

javax.servlet.http.HttpServlet を継承するクラス。

HTTPリクエスト（主にWebブラウザから）を受け取って処理する Javaのサーバーサイドコンポーネント。

Webアプリケーションにおける コントローラーの役割 を持ちます（MVCモデルで言う「C」）。


[ユーザー操作]

   ↓

[Servlet] → [DBUtils] → [ConnectionUtils] → [MySQLConnUtils]
