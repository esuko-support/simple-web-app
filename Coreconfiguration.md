## コア構成の把握	Servlet ⇄ DBUtils ⇄ Connection	呼び出し順／責任分離
用語解説：「コア (core)」 
意味：英語の「core」は「中心」「核」「基盤」といった意味です。
- この場での使い方：アプリケーション全体の処理の中心的な流れや構成のことを指します。つまり、このアプリが何をするために、どのクラスや機能がどう繋がって動くのかを表すものです。

## データ構造の把握	Product クラスなどのBean定義	データの形（値オブジェクト）
## 画面連携の流れ	JSP, web.xml, request.setAttribute()	Viewの動き・渡すデータ
## 共通処理の役割	MyUtils, Filter, conn.*	繰り返し使われる部品たち
## 例外処理／セキュリティ	try-catch, rollback, web.xml制御	安定性と安全性の仕組み

## Servletとは？
- javax.servlet.http.HttpServlet を継承するクラス。
- HTTPリクエスト（主にWebブラウザから）を受け取って処理する Javaのサーバーサイドコンポーネント。
- Webアプリケーションにおける コントローラーの役割 を持ちます（MVCモデルで言う「C」）。

## なぜServletが「最初に呼ばれる」のか？
WebアプリケーションにはリクエストURLとServletのマッピング設定が存在します。
- @WebServlet(urlPatterns = {"/createProduct"}) のように指定されている。
- ブラウザから http://.../createProduct にアクセスがあると、Tomcat等のWebサーバーがそのリクエストを該当のServletに転送します。
- そのServletの doGet() や doPost() メソッドが呼ばれ、処理が始まります。

servlet/ フォルダには ユーザーの行動（ログイン、登録、編集など）ごとの入口処理 がまとまっています。
- Servletはユーザー操作の「受け口」です。ここから他のユーティリティやデータベース処理に指示を出す構造です。

## どのServletが「最初に」呼ばれるのか？
明確に「最初」と言えるのは Webアプリにアクセスしたときの最初のURL によって決まります。
たとえば、ログイン画面から始まるのであれば LoginServlet、商品作成画面からであれば CreateProductServlet です。
この起点URLは @WebServlet(...) によってURLマッピングされ、Webサーバーが自動的にそのServletを起動します。

## MVCモデル
- M	Model（モデル）	データやビジネスロジックの処理（データの定義・計算・DB操作など）
- V	View（ビュー）	ユーザーに見せる画面・出力（HTMLやJSPなど）
- C	Controller（コントローラー）	ユーザーの入力を受け取り、ModelやViewと連携して処理の指示を出す

## ユーザー → 「商品を登録」ボタンをクリック。この一連の流れをMVCに分けると
Controller（コントローラー）:DoCreateProductServlet.java
- ブラウザからのリクエストを受け取る
- 入力データ（商品名・価格など）を取得し、Modelに渡す
- 最終的に表示用のJSPへ遷移（フォワードまたはリダイレクト）

Model（モデル）:Product.java（Bean）,DBUtils.java（DB操作）
- ユーザーから受け取った商品情報を使ってデータベースに保存などを行う

View（ビュー）:createProductView.jsp,productListView.jsp
- HTMLとしてユーザーに出力する内容を定義

なぜMVCに分けるのか
- 責任分離	各部品の役割を明確にすることで、メンテナンス性が高まる
- 再利用性	Modelは他のControllerからも使える（Viewを変えてもロジックは変わらない）
- 開発の分担	フロントエンドとバックエンドを並行で作業しやすい
- 保守性	Viewの見た目だけ変えたいとき、Modelに影響を与えないようにできる


[ユーザー操作]

   ↓

[Servlet] → [DBUtils] → [ConnectionUtils] → [MySQLConnUtils]
