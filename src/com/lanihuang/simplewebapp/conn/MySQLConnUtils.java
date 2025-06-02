package com.lanihuang.simplewebapp.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

//引数なし getMySQLConnection()
  public static Connection getMySQLConnection()
  throws ClassNotFoundException, SQLException {
    //DB接続に必要なパラメータ（ホスト名、DB名、ユーザー名、パスワード）を固定で設定
    String hostName = "us-cdbr-iron-east-04.cleardb.net";
    String dbName = "heroku_2c893dd9e4fdf5d";
    String userName = "bc7a403442c80e";
    String password = "d85f72d1";
    // 下のメソッドに委譲（引数あり版を呼び出す）
    return getMySQLConnection(hostName, dbName, userName, password);
  }

//引数あり getMySQLConnection(...)
//外部から 接続先情報を柔軟に指定できるバージョン
//実際の接続処理はここで行われる
  public static Connection getMySQLConnection(String hostName, String dbName,
      String userName, String password) throws SQLException,
    ClassNotFoundException {

    //JDBCドライバのロード
    //これにより DriverManager が MySQL接続用のドライバを認識可能になる
    Class.forName("com.mysql.jdbc.Driver");

    // URL Connection for MySQL
    // Example: jdbc:mysql://localhost:3306/simplehr
    String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    Connection conn = DriverManager.getConnection(connectionURL, userName,
                      password);
    return conn;
  }

}
