# example-springfox
Springfox(Swagger)でAPI仕様書を作るサンプル

## Spec

### Framework

- SpringBoot2
- Spring MVC (Rest)
- SpringFox (Swagger)

### Build

- Maven

### DB

- none

## 超概要

swagger.json > ascii-doc > HTML まで変換する

1. ソースコードにSwaggerを導入
2. Swagger定義ファイルを出力
3. Swagger定義ファイルからascii-docを出力
4. ascii-docをHTMLに変換

### 参考リンク

[Swagger 定義ファイルから そこそこいい感じの静的 REST API ドキュメント作成する](https://iktakahiro.hatenablog.com/entry/2016/11/23/100000)

### Swaggerを導入

- pom.xmlにSwaggerを追加（Initialzrでは追加できない）
- JavaConfigを作成、@EnableSwagger2アノテーションをつける
- SpringMVCのアノテーションからよしなに定義を拾ってくれる

### Swagger定義ファイルを出力

- SpringBootを起動
- Swagger-uiにアクセス(http://localhost:8080/)
- swagger.jsonを表示(http://localhost:8080/v2/api-docs/)

### Swagger定義ファイルからascii-docを出力

[swagger2markup-cli GitHub](https://github.com/Swagger2Markup/swagger2markup-cli)

- [GitHub](https://github.com/Swagger2Markup/swagger2markup-cli) からクローン
- gradleビルドしてjarを生成
- jarを実行

```shellscript
### clone
$ git clone https://github.com/Swagger2Markup/swagger2markup-cli.git
### build
$ cd swagger2markup-cli
$ gradle assemble
### execute
$ cd build/libs/
$  java -jar swagger2markup-cli-1.3.3.jar convert -i sample.json -f api-doc
```

---

### ascii-docをHTMLに変換

asciidoctorにおまかせ

[asciidoctor GitHub](https://github.com/asciidoctor/asciidoctor/blob/master/README-jp.adoc)

```shellscript
### install
$ sudo gem install asciidoctor
### execute
$ asciidoctor -a toc=left api-doc.adoc 
### browser
$ open "/Applications/Google Chrome.app" api-doc.html 
```
