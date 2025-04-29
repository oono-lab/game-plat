# ベースイメージ（JDK入りのやつ）
FROM openjdk:17

# jarファイルをコンテナにコピー（後で名前直すかも）
COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# アプリ実行
ENTRYPOINT ["java","-jar","/app.jar"]
