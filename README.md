#  AndroidSweets (🚧 WIP!!)
## 概要
[AndroidDagashi](https://androiddagashi.github.io/) の購読アプリです。通知などを用いてコツコツと AndroidDagashi の記事を読むことを習慣化させたり、タグやお気に入り機能で読みたい記事を手軽にチョイスできるようなアプリを目指しています

## 技術スタック
- Minimum SDK level 26
- フル Kotlin
- [マルチモジュール化](https://developer.android.com/topic/modularization?hl=ja) 対応
- Jetpack
    - Compose: 宣言的にUIを構築
    - ViewModel
    - Hilt: 依存性の注入
    - Room: お気に入り機能などに使う
    - Navigation: 画面遷移
- Coroutines + Flow: 非同期処理
- Material Design
- kotlinx.serialization: Json のシリアライズ、デシリアライズ
- Retrofit: Github APIとのHTTP通信
- [EitherNet](https://github.com/slackhq/EitherNet): Retrofit のエラーハンドリング
- ksp
- [spotless](https://github.com/diffplug/spotless): フォーマッタ
- composite-build: build.gradle.kts における設定の共通化 (最近流行りのやつ)

## アーキテクチャ
Googleの[アプリアーキテクチャガイド](https://developer.android.com/topic/architecture?hl=ja)に準拠しています。
大きく`app`、`core`、`feature` の３つのモジュールで構成しています

## ロードマップ
- [ ] タイムライン
- [ ] お気に入り機能
- [ ] 通知機能 (1週間未読時、記事更新時など)
- [ ] カテゴリで記事を絞る機能
- [ ] Githubの草のようなヒートマップ
- [ ] ダークモードなどの設定
