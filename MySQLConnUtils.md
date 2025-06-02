#クラス名	MySQLConnUtils（接続ユーティリティ）
このクラスは データベース接続を提供するユーティリティクラス。
Utils という名前の通り、インスタンス化せず静的に使うことを想定しています。

#役割	MySQLデータベースとの接続（Connection オブジェクト）を取得する
#使われ方	他クラス（例：ConnectionUtils）が内部的に利用し、DB操作の起点となる

## 1.2 構成
- JDBCドライバをロードするために `Class.forName()` を使用
  - Javaでは、JDBC（Java Database Connectivity）というAPIを使ってDBにアクセスします。
  - JDBCドライバは、そのAPIの呼び出しを、特定のDBに適した命令へ翻訳する役割を担います。
  jdbc:mysql:// は何か？
これは JavaアプリがMySQLデータベースに接続するための接続URL です。
このURLは JDBC（Java Database Connectivity）というJava専用のDB接続APIが使う**独自のスキーム（形式）**です。




- `DriverManager.getConnection(...)` により実際の接続を生成
- 接続情報は `host`, `dbName`, `user`, `password` を内部で指定

## 関連クラス
- `ConnectionUtils.getConnection()` がこのクラスの `getMySQLConnection()` を利用
- `DBUtils` や `Servlet` 層から間接的に使用される
