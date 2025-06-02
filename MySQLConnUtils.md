# 1. MySQLConnUtils.java の概要

## 1.1 目的
MySQLデータベースへの接続を行うユーティリティクラス。

## 1.2 構成
- JDBCドライバをロードするために `Class.forName()` を使用
- Javaでは、JDBC（Java Database Connectivity）というAPIを使ってDBにアクセスします。
- JDBCドライバは、そのAPIの呼び出しを、特定のDBに適した命令へ翻訳する役割を担います。



- `DriverManager.getConnection(...)` により実際の接続を生成
- 接続情報は `host`, `dbName`, `user`, `password` を内部で指定

## 関連クラス
- `ConnectionUtils.getConnection()` がこのクラスの `getMySQLConnection()` を利用
- `DBUtils` や `Servlet` 層から間接的に使用される
