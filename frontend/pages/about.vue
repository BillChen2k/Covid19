<template>
  <div class="About">
    <page-header
      icon="mdi-information-outline"
      title="关于项目"
      date=""
    />
    <TextCard title="简介">
      <v-row>
        <v-col sm="12" md="6">
          <p>
            这是一个 Covid-19 新冠疫情分析与管理项目，为华东师范大学软件工程专业 2020 年数据库系统课程的期末项目。具有全球疫情可视化概览、病人诊断数据统计及编辑、诊断医院和医生管理等功能。
          </p>
          <p>
            网站前端采用 <code>vue.js</code> 架构，基于 <code>nuxt.js</code> 实现高性能的 SSR （服务端渲染）。使用 <code>vuetify</code> 作为主要的 UI 库。后端采用 <code>Spring Boot</code> 架构，使用 <code>Swagger UI</code> 生成 API 文档。
            数据库采用 <code>MySQL Community Version 8.0.12</code>, 存有两万余医生数据，十三万患者数据，四十万余条处方数据，近四百万余条诊断记录。经过多重索引和外键优化，平均性能仍较优秀。
          </p>
          <p>
            你可以在 <a href="http://8.210.248.203/docs.html" target="_blank">http://8.210.248.203/docs.html</a> 查阅由 <code>knif4j</code> 生成的后端 API 文档，含有调用参数、返回信息等数据。
          </p>
          <p>
            你可以在 <a href="https://github.com/billchen2k/Covid19" target="_blank">https://github.com/billchen2k/Covid19</a> 获取项目的源代码，或通过 commit 来回顾本项目的开发进度。
          </p>
          <p>
            另外，由于服务器假设在香港，在某些情况下项目的访问速度可能比较缓慢。
          </p>
        </v-col>
        <v-col sm="12" md="6">
          <v-card outlined rounded class="pa-2">
            <v-card-text>数据库 ER 图</v-card-text>
            <v-row>
              <v-spacer></v-spacer>
              <img class="px-8" src="/er.png" width="80%" />
              <v-spacer></v-spacer>
            </v-row>
          </v-card>
        </v-col>
      </v-row>

    </TextCard>

    <TextCard title="作者">
      本项目的小组成员如下：
      <v-data-table
        :headers="author.headers"
        :items="author.data"
        :items-per-page="-1"
        :hide-default-footer="true"
        :fixed-header="true"
        :mobile-breakpoint="0"
        class="cardTable"
      >
        <template v-slot:item.contact = {item}>
          <a :href="`mailto:${item.contact}`">{{item.contact}}</a>
        </template>
      </v-data-table>
    </TextCard>



    <TextCard title="特别鸣谢">
      <p>
        本项目的前端部分参考了基于 MIT 协议的开源项目
        <a
          href="https://github.com/tokyo-metropolitan-gov/covid19"
          target="_blank"
          rel="noopener"
          place="githubRepo"
        >
          「東京都 新型コロナウイルス感染症対策サイト」
        </a>
        。原项目仅提供了日本疫情数据的可视化展示，我们在该项目的基础上，实现了针对每个具体病人的详细信息的增删改查、处方、诊断记录等的检索与修改功能，以及针对医生和医院的用户权限系统。
      </p>
      <p>
        疫情数据主要来源为丁香园每日统计数据。除此之外的医院、医生、药物、诊断记录、处方信息均为由脚本生成的虚构数据。
      </p>

    </TextCard>


    <TextCard title="关于浏览器">
      网站使用 <code>vue.js</code> 架构。为了保证浏览体验和性能，建议使用以下浏览器：<br />
      <ul class="About-Browser-List">
        <li>{{ $t('Microsoft Edge 最新版') }}</li>
        <li>{{ $t('Mozilla Firefox 最新版') }}</li>
        <li>{{ $t('Google Chrome 最新版（Windows 10以上）') }}</li>
        <li>{{ $t('Apple Safari (macOS) 最新版') }}</li>
        <li>{{ $t('Opera Software ASA Opera 最新版') }}</li>
      </ul>
    使用其他浏览器可能会造成浏览问题。
    </TextCard>


    <TextCard :title="$t('JavaScriptについて')">
      {{ $t('当サイトではJavaScriptを使用しております。') }}<br />
      {{
        $t(
          'JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。'
        )
      }}<br />
      {{
        $t(
          '当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。'
        )
      }}
    </TextCard>

    <TextCard :title="$t('クッキー (Cookie) について')">
      {{ $t('当サイトの一部ではクッキーを使用しています。') }}<br />
      {{
        $t(
          'クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。'
        )
      }}<br />
      <br />
      {{
        $t(
          'ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。'
        )
      }}<br />
      <br />
      {{
        $t(
          'ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。'
        )
      }}
    </TextCard>

    <v-row>
      <v-spacer></v-spacer>
      <span class="grey--text">Crafted with ❤️, 2020.3 - 2020.8</span>
      <v-spacer></v-spacer>
    </v-row>


  </div>
</template>

<i18n>
{
  "ja": {
    "当サイトについて": "当サイトについて",
    "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。": "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。",
    "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。": "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。",
    "ブラウザ環境について": "ブラウザ環境について",
    "当サイトは以下の環境でご覧いただくことを推奨いたします。": "当サイトは以下の環境でご覧いただくことを推奨いたします。",
    "Microsoft Edge 最新版": "Microsoft Edge 最新版",
    "Mozilla Firefox 最新版": "Mozilla Firefox 最新版",
    "Google Chrome 最新版（Windows 10以上）": "Google Chrome 最新版（Windows 10以上）",
    "Apple Safari (macOS) 最新版": "Apple Safari (macOS) 最新版",
    "Opera Software ASA Opera 最新版": "Opera Software ASA Opera 最新版",
    "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。": "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。",
    "当サイトへのリンクについて": "当サイトへのリンクについて",
    "当サイトへのリンクは自由です。": "当サイトへのリンクは自由です。",
    "JavaScriptについて": "JavaScriptについて",
    "当サイトではJavaScriptを使用しております。": "当サイトではJavaScriptを使用しております。",
    "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。": "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。",
    "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。": "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。",
    "クッキー (Cookie) について": "クッキー (Cookie) について",
    "当サイトの一部ではクッキーを使用しています。": "当サイトの一部ではクッキーを使用しています。",
    "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。": "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。",
    "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。": "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。",
    "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。": "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。",
    "Google Analyticsの利用について": "Google Analyticsの利用について",
    "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。": "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。",
    "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。": "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。",
    "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。": "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。",
    "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。": "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。",
    "Google Analytics利用規約": "Google Analytics利用規約",
    "Googleのプライバシーポリシー": "Googleのプライバシーポリシー",
    "Google Analyticsに関する詳細情報": "Google Analyticsに関する詳細情報",
    "免責事項": "免責事項",
    "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。": "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。",
    "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。": "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。",
    "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。": "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。",
    "データについて": "データについて",
    "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）": "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）",
    "東京都オープンデータカタログサイト": "東京都オープンデータカタログサイト",
    "ソースコードについて": "ソースコードについて",
    "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。": "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。",
    "詳しくは、{githubRepo}をご確認ください。": "詳しくは、{githubRepo}をご確認ください。",
    "GitHub リポジトリ": "GitHub リポジトリ",
    "お問い合わせ先": "お問い合わせ先",
    "東京都生活文化局広報広聴部広報課": "東京都生活文化局広報広聴部広報課",
    "電話": "電話"
  },
  "en": {
    "当サイトについて": "About the website",
    "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。": "This site was developed by the Tokyo Metropolitan Government in order to provide the latest information on COVID-19.",
    "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。": "The goal is to provide easy to understand, publicly available, and unbiased information on the spread of infection in the Tokyo metropolis. This allows the residents, companies, as well as visitors to Tokyo, understand the current situation while having the right information about the necessary precautions and measures.",
    "ブラウザ環境について": "Browser compatibility",
    "当サイトは以下の環境でご覧いただくことを推奨いたします。": "It is recommended to use the following browsers when viewing this site.",
    "Microsoft Edge 最新版": "Microsoft Edge (Latest version)",
    "Mozilla Firefox 最新版": "Mozilla Firefox (Latest version)",
    "Google Chrome 最新版（Windows 10以上）": "Google Chrome (Latest version, Windows 10 or later)",
    "Apple Safari (macOS) 最新版": "Apple Safari (macOS) Latest version",
    "Opera Software ASA Opera 最新版": "Opera Software ASA Opera Latest version",
    "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。": "When viewing this site, regardless of whether the recommended browsers are used or not, please understand that site elements may not display correctly due to some pre-defined settings in the browser being used.",
    "当サイトへのリンクについて": "About linking to this site",
    "当サイトへのリンクは自由です。": "No permission is required to link this site.",
    "JavaScriptについて": "About JavaScript",
    "当サイトではJavaScriptを使用しております。": "This site uses JavaScript.",
    "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。": "If JavaScript is disabled, the site may not work as expected or may not display correctly.",
    "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。": "Please make sure to enable JavaScript when browsing this site.",
    "クッキー (Cookie) について": "About cookies",
    "当サイトの一部ではクッキーを使用しています。": "This site uses cookies.",
    "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。": "Cookies are temporarily stored data from web requests and are used to know the usage statistics of this site.",
    "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。": "If you do not wish your browsing data to be collected, please disable cookies from your web browser.",
    "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。": "However, if you disable cookies, this site may not work as expected.",
    "Google Analyticsの利用について": "Regarding the use of Google Analytics",
    "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。": "This site uses Google Analytics, an access analysis tool provided by Google LLC, to provide better services.",
    "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。": "Google Analytics uses Cookies to collect anonymous usage data(page views, traffic, used OS/browser information and so on). We use Cookies based on Google's privacy policy and terms.",
    "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。": "The acquired data will only be used for purposes related to analyzing website use, creating reports to publishers and providing other services.",
    "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。": "About Google Analytics Terms of Service and Privacy Policy, please visit the Google Analytics site.",
    "Google Analytics利用規約": "Google Analytics Terms of Service",
    "Googleのプライバシーポリシー": "Google's Privacy Policy",
    "Google Analyticsに関する詳細情報": "Google Analytics Details",
    "免責事項": "Disclaimers",
    "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。": "Although every effort has been made to ensure the accuracy of the information posted on this site, Tokyo Metropolitan Government is not responsible for any actions taken by users using the information on this site.",
    "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。": "Website will not be responsible in case any user uses the website data in a way that causes, or is likely to cause any damage.",
    "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。": "Any information on this site may be changed or deleted without prior notice.",
    "データについて": "About data",
    "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）": "Anyone can freely download the data published on this site from {catalogWebsite}. (Data will be added sequentially)",
    "東京都オープンデータカタログサイト": "the Tokyo Metropolitan Government Open Data Catalog site",
    "ソースコードについて": "About the source code",
    "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。": "The source code of this site is released under the MIT license that anyone can use freely.",
    "詳しくは、{githubRepo}をご確認ください。": "For details, please check {githubRepo}.",
    "GitHub リポジトリ": "the GitHub repository",
    "お問い合わせ先": "Contact",
    "東京都生活文化局広報広聴部広報課": "Department of Public Relations, Tokyo Bureau of Citizens and Cultural Affairs",
    "電話": "TEL"
  },
  "zh-cn": {
    "当サイトについて": "关于本站",
    "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。": "本网站是由东京都政府开设，用于提供关于新型冠状病毒肺炎(COVID-19)的最新资讯。",
    "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。": "本网站的目的是透过东京都的官方情报与客观数字，希望可以让住在东京的人、在东京有办公室的企业、以及来访东京的人，可以正确把握现状并采取适当的对策。",
    "ブラウザ環境について": "关于网页浏览器",
    "当サイトは以下の環境でご覧いただくことを推奨いたします。": "本网站建议使用以下浏览器",
    "Microsoft Edge 最新版": "Microsoft Edge 最新版",
    "Mozilla Firefox 最新版": "Mozilla Firefox 最新版",
    "Google Chrome 最新版（Windows 10以上）": "Google Chrome 最新版（Windows 10以上）",
    "Apple Safari (macOS) 最新版": "Apple Safari (macOS) 最新版",
    "Opera Software ASA Opera 最新版": "Opera Software ASA Opera 最新版",
    "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。": "※ 请注意，如果您使用的是上述以外的浏览器，由于设定的关系，可能会造成部分网页无法正常显示。",
    "当サイトへのリンクについて": "关于本网站的分享",
    "当サイトへのリンクは自由です。": "可以自由转发本网站的连结。",
    "JavaScriptについて": "关于 JavaScript",
    "当サイトではJavaScriptを使用しております。": "本网站使用了 JavaScript。",
    "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。": "如果您将 JavaScript 设为无效化，会造成网页无法正常操作，或者造成网页无法正常显示。",
    "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。": "当您使用本网站时，请务必将 JavaScript 设为有效。",
    "クッキー (Cookie) について": "关于 Cookie 的使用",
    "当サイトの一部ではクッキーを使用しています。": "本网站有部分使用 Cookie。",
    "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。": "Cookie 是将网站的一部分情报存在客户端的一种方法。本网站有一部分会使用 Cookie 来确认利用状况。",
    "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。": "如果您不希望被收集浏览时的讯息，您可以将浏览器的 Cookie 功能关闭。",
    "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。": "不过如果当您关闭了 Cookie 功能，可能会造成部分网页无法正常操作。",
    "Google Analyticsの利用について": "关于 Google Analytics 的使用",
    "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。": "本网站为了改善使用性，导入了 Google 的流量分析工具 Google Analytics，以便计算分析。",
    "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。": "Google Analytics 会使用本网站发行的 Cookie 收集不包含个人信息在内的网站使用状况（如浏览次数，流量及浏览器运行环境等）。Cookie 的使用基于 Google 的隐私权政策与条款。",
    "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。": "收集的信息仅用于网站使用状况分析、向网站运营方的报告及提供相关服务时的参考。",
    "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。": "关于 Google Analytice 的使用条款与隐私政策的说明，请参考 Google Analytics 的网站。",
    "Google Analytics利用規約": "Google Analytics 服务条款",
    "Googleのプライバシーポリシー": "Google 隐私权政策",
    "Google Analyticsに関する詳細情報": "关于 Google Analytics 的详情",
    "免責事項": "免责声明",
    "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。": "本网站会尽可能保证资讯的准确性。东京都政府不承担使用本网站资讯时的责任。",
    "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。": "如使用者因使用本网站而产生损害或造成他人损害，本网站概不负责。",
    "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。": "本网站的资讯内容可能会随时进行变更或消除，恕不另行通知。",
    "データについて": "本站数据",
    "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）": "本网站内所公布的数据，可于{catalogWebsite}自行下载。（数据会随时添加）",
    "東京都オープンデータカタログサイト": "东京都数据开放平台",
    "ソースコードについて": "关于代码开源",
    "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。": "本网站采用 MIT 许可证，任何人都可以自由的使用",
    "詳しくは、{githubRepo}をご確認ください。": "详情请参考 {githubRepo}。",
    "GitHub リポジトリ": "GitHub 仓库",
    "お問い合わせ先": "联系方式",
    "東京都生活文化局広報広聴部広報課": "东京都生活文化局宣传部宣传科",
    "電話": "TEL"
  },
  "zh-tw": {
    "当サイトについて": "關於本網站",
    "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。": "本網站是由東京都政府開設，用於提供關於新型冠狀病毒肺炎 (COVID-19) 的最新訊息。",
    "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。": "本網站的目的是，透過東京都的官方情報與客觀數字，我們希望可以讓住在東京的人，以及在東京有辦公室的企業，還有來訪東京的人，可以正確掌握即時現況，並採取適當的對策。",
    "ブラウザ環境について": "瀏覽器相容性",
    "当サイトは以下の環境でご覧いただくことを推奨いたします。": "本網站建議使用以下瀏覽器",
    "Microsoft Edge 最新版": "Microsoft Edge 最新版",
    "Mozilla Firefox 最新版": "Mozilla Firefox 最新版",
    "Google Chrome 最新版（Windows 10以上）": "Google Chrome 最新版（Windows 10或以上）",
    "Apple Safari (macOS) 最新版": "Apple Safari (macOS) 最新版",
    "Opera Software ASA Opera 最新版": "Opera Software ASA Opera 最新版",
    "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。": "※ 請注意，若您使用的是建議以外的瀏覽器，由於設定的關係，可能會造成部分網頁無法正常顯示。",
    "当サイトへのリンクについて": "關於本網站的分享",
    "当サイトへのリンクは自由です。": "可以自由轉發本網站的連結。",
    "JavaScriptについて": "關於 JavaScript",
    "当サイトではJavaScriptを使用しております。": "本網站使用了 JavaScript。",
    "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。": "如果您停用了 JavaScript，會造成網頁無法正常操作，或者造成網頁無法正常顯示。",
    "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。": "當您使用本網站時，請務必啟用 JavaScript。",
    "クッキー (Cookie) について": "關於 Cookie 的使用",
    "当サイトの一部ではクッキーを使用しています。": "本網站有部分使用 Cookie。",
    "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。": "Cookie 是將網站的一部分情報存在客戶端的一種方法。本網站有一部分會使用 Cookie 來確認利用狀況。",
    "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。": "如果您不希望被收集瀏覽時的訊息，您可以將瀏覽器的 Cookie 功能關閉。",
    "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。": "不過如果當您關閉了 Cookie 功能，可能會造成部分網頁無法正常操作。",
    "Google Analyticsの利用について": "關於 Google Analytics 的使用",
    "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。": "本網站為了改善服務，導入了 Google 的流量分析工具 Google Analytics。",
    "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。": "Google Analytics 也會利用本網站發行的 Cookie ，來收集不包含特定個人情報的網站利用情報（瀏覽次數、流量、瀏覽方式等）。Cookie 的利用，是基於 Google 的隱私權政策與條款來運作。",
    "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。": "蒐集資料的用途，僅限定於本網站的利用狀況分析，以及網站營運報告的作成，還有同相關服務提供時的參考。",
    "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。": "關於 Google Analytice 的使用條款與隱私政策的說明，請參考 Google Analytics 的網站。",
    "Google Analytics利用規約": "Google Analytics 服務條款",
    "Googleのプライバシーポリシー": "Google 隱私權政策",
    "Google Analyticsに関する詳細情報": "關於 Google Analytics 的詳情",
    "免責事項": "免責聲明",
    "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。": "本網站盡可能的保持資訊的準確性。東京都政府並不承擔任何轉用本網站資訊時的責任。",
    "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。": "若使用者因使用本網站而發生損害，或造成及於第三人之損害，本網站概不負責。",
    "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。": "本網站所登載的資訊，我們有權隨時變更或刪除，且毋須事先通知。",
    "データについて": "資料說明",
    "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）": "本網站內公佈之資料，可至{catalogWebsite}自由下載。（資料將會隨時增加）",
    "東京都オープンデータカタログサイト": "東京都資料開放平臺",
    "ソースコードについて": "源碼說明",
    "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。": "本站源碼採用 MIT 授權釋出，任何人都可以自由運用。",
    "詳しくは、{githubRepo}をご確認ください。": "詳情請參閱 {githubRepo}。",
    "GitHub リポジトリ": "GitHub 版本庫",
    "お問い合わせ先": "聯絡方式與部門",
    "東京都生活文化局広報広聴部広報課": "東京都生活文化局廣報廣聽部廣報課",
    "電話": "電話"
  },
  "ko": {
    "当サイトについて": "본 사이트에 관하여",
    "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。": "본 사이트는 신종 코로나 바이러스 감염 (COVID-19) 에 대한 최신 정보를 제공하기 위해 도쿄도가 개설하였습니다.",
    "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。": "도쿄도의 공식 정보와 객관적인 수치를 알기 쉽게 전달함으로써, 도쿄에 거주하는 분이나, 도쿄에 거점을 둔 기업인, 도쿄를 방문하는 분들이 현재 상황을 파악하고 적절한 예방책과 대책을 취할 수 있도록 하는 것이 목적입니다.",
    "ブラウザ環境について": "브라우저 환경",
    "当サイトは以下の環境でご覧いただくことを推奨いたします。": "본 사이트는 다음의 환경에서 사용하기를 권합니다.",
    "Microsoft Edge 最新版": "Microsoft Edge 최신판",
    "Mozilla Firefox 最新版": "Mozilla Firefox 최신판",
    "Google Chrome 最新版（Windows 10以上）": "Google Chrome 최신판（Windows 10이상）",
    "Apple Safari (macOS) 最新版": "Apple Safari (macOS) 최신판",
    "Opera Software ASA Opera 最新版": "Opera Software ASA Opera 최신판",
    "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。": "※ 본 사이트를 이용할시에, 권장하는 브라우저를 사용하는 것과 무관하게, 브라우저의 설정에 따라 올바르게 표시되지 않을 수 있으니 양해 바랍니다.",
    "当サイトへのリンクについて": "본 사이트의 링크에 대해서",
    "当サイトへのリンクは自由です。": "본 사이트의 링크의 공유는 자유입니다.",
    "JavaScriptについて": "자바스크립트에 대하여",
    "当サイトではJavaScriptを使用しております。": "본 웹사이트에서는 자바스크립트를 사용합니다.",
    "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。": "자바스크립트를 허용하지 않으면 각 페이지가 제대로 작동하지 않거나 표시되지 않을 수 있습니다.",
    "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。": "본 웹사이트를 이용시에는 자바스크립트를 허용해 주시기를 요청드립니다.",
    "クッキー (Cookie) について": "쿠키 (Cookie) 에 대해",
    "当サイトの一部ではクッキーを使用しています。": "본 웹사이트의 일부에는 쿠키를 사용하고 있습니다.",
    "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。": "쿠키는 웹 컨텐츠의 요청시에 이용자의 장치에 일시적으로 저장되는 데이터로, 본 웹사이트에서는 이용 상황 파악을 위해 쿠키를 사용하는 경우가 있습니다.",
    "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。": "브라우저에 대한 정보 수집을 원하지 않을 경우, 웹 브라우저의 설정을 변경해 주심으로써 쿠키 기능을 정지 시킬 수 있습니다.",
    "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。": "다만, 쿠키를 허용하지 않으면 본 사이트의 기능이 제대로 작동하지 않는 경우가 있습니다.",
    "Google Analyticsの利用について": "Google Analytics 의 이용에 대해",
    "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。": "본 사이트는 서비스 개선 및 웹사이트의 개선을 위해 Google LLC 가 제공하는 접속 분석 도구인 Google Analytics 를 이용한 분석을 있습니다.",
    "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。": "Google Analytics 는 사이트가 발행하는 쿠키 (Cookie) 를 이용하여 개인을 식별하는 정보를 포함하지 않는 상태로, Web 사이트의 이용 데이터 （접속 상황, 트래픽, 열람 환경 등）를 수집합니다. 쿠키 (Cookie) 의 이용에 대해서는 Google 의 개인 정보 보호 및 약관을 따릅니다.",
    "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。": "수집한 데이터는 웹사이트 사용 현황 분석, 사이트 운영자에 대한 보고서 작성, 기타 서비스 제공에 관한 목적에만 한하여 사용합니다.",
    "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。": "Google Analytics 이용 약관 및 개인 정보 보호 정책에 대한 설명은 Google Analytics 사이트를 참조하십시오.",
    "Google Analytics利用規約": "Google Analytics 이용 약관",
    "Googleのプライバシーポリシー": "Google 개인 정보 보호 정책",
    "Google Analyticsに関する詳細情報": "Google Analytics에 대한 자세한 정보",
    "免責事項": "면책조항",
    "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。": "본 사이트에 게재되는 정보의 정확성에 최선을 다하고 있습니다만, 도쿄도는 이용자가 본 사이트의 정보를 활용해 행하는 모든 행위에 대해서 책임을 지지 않습니다.",
    "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。": "또한, 이용자가 본 사이트를 이용함으로써 발생한 이용자의 손해 및 이용자가 제삼자에게 입힌 손해에 대하여 책임을 지지 않습니다.",
    "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。": "본 사이트에 게재되고 있는 정보는 예고없이 변경 또는 삭제할 수 있습니다.",
    "データについて": "데이터에 관해서",
    "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）": "본 사이트에서 공개되는 데이터는 {catalogWebsite} 에서 누구나 자유롭게 다운받을 수 있습니다. (데이터는 순차적으로 추가될 예정입니다)",
    "東京都オープンデータカタログサイト": "도쿄도 오픈 데이터 포털",
    "ソースコードについて": "소스코드에 대해서",
    "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。": "본 사이트의 소스 코드는 MIT 라이센스로 공개되어있어 누구라도 자유롭게 이용할 수 있습니다.",
    "詳しくは、{githubRepo}をご確認ください。": "자세한 내용은 {githubRepo}를 확인하십시오.",
    "GitHub リポジトリ": "GitHub 리포지터리",
    "お問い合わせ先": "문의처",
    "東京都生活文化局広報広聴部広報課": "도쿄도 생활문화국 홍보광청부 홍보과",
    "電話": "전화"
  },
  "ja-basic": {
    "当サイトについて": "このインターネットページのこと",
    "当サイトは新型コロナウイルス感染症 (COVID-19) に関する最新情報を提供するために、東京都が開設したものです。": "このページは とうきょうとが つくりました。あたらしい じょうほうが みられます",
    "東京都による公式情報と客観的な数値をわかりやすく伝えることで、東京都にお住まいの方や、東京都内に拠点を持つ企業の方、東京都を訪れる方が、現状を把握して適切な対策を取れるようにすることを目的としています。": "このページをつくったのは、とうきょうと が いろいろなデータ、すうじ を わかりやすく つたえるため です。すんでいる ひと、はたらいている ひと、とうきょう に きた ひと が、いま を ただしくわかり、かんがえられる よう にする ため です",
    "ブラウザ環境について": "ページ を みる ための インターネット に つなぐ かんきょう について",
    "当サイトは以下の環境でご覧いただくことを推奨いたします。": "この インターネット ページ は、つぎ の かんきょう で みて もらうことを おすすめ します",
    "Microsoft Edge 最新版": "Microsoft Edge いちばんあたらしいもの",
    "Mozilla Firefox 最新版": "Mozilla Firefox いちばんあたらしいもの",
    "Google Chrome 最新版（Windows 10以上）": "Google Chrome いちばんあたらしいもの（Windows 10よりあたらしいもの）",
    "Apple Safari (macOS) 最新版": "Apple Safari (macOS) いちばんあたらしいもの",
    "Opera Software ASA Opera 最新版": "Opera Software ASA Opera いちばんあたらしいもの",
    "※ 推奨環境以外で利用された場合や、推奨環境下でもご利用のブラウザの設定等によっては、正しく表示されない場合がありますのでご了承ください。": "※ ちゅうい: おすすめ の インターネット に つなぐ かんきょう で みないと、ただしく みる ことができない かもしれません。",
    "当サイトへのリンクについて": "この ページ に つなげる ための インターネットリンク に ついて",
    "当サイトへのリンクは自由です。": "この ページへ の リンク は じゆう です",
    "JavaScriptについて": "JavaScript（ジャバスクリプト）について",
    "当サイトではJavaScriptを使用しております。": "このページでは、JavaScript という ぎじゅつ をつかっています。",
    "JavaScriptを無効にして使用された場合、各ページが正常に動作しない、または、表示されない場合がございます。": "これを OFF にしていると、ページが うまく みられない とき が あります。",
    "当サイトをご利用の際には、JavaScriptを有効にして頂きますようお願いいたします。": "ON に して ください。",
    "クッキー (Cookie) について": "Cookie（クッキー）について",
    "当サイトの一部ではクッキーを使用しています。": "このページでは、Cookieというぎじゅつをつかっています。",
    "クッキーとは、Webコンテンツからの要求で利用者の手元の端末に一時的に保存されるデータのことで、当サイトでは利用状況の把握のためにクッキーを使用する場合があります。": "この ページ では、Cookieという ぎじゅつ を つかっています。クッキーとは、インターネットページ から、あなた の けいたいでんわ やパソコン など みているきかいに ほぞんされる データ のことです。このページでは みんな のために なっているか つかわれかた をしる ために、クッキー をつかう とき が あります。",
    "ブラウザに関する情報の収集を希望しない場合は、インターネット閲覧ソフト（ブラウザ）をご自身で設定することにより、クッキーの機能が働かないようにすることも可能です。": "クッキー を つかわれたくない とき、インターネット に つなぐ ソフト の せってい を じぶん で かえることで、OFFに する ことも できます",
    "ただし、クッキーを受け入れない設定をされている場合は、当サイトの機能が正常に動作しない場合がございます。": "ただし、クッキー を OFF に した ばあい、この ページ が うまく みることが できない とき が あります",
    "Google Analyticsの利用について": "Google Analytics を つかう こと に ついて",
    "当サイトでは、サービス向上やサイトの改善のためにGoogle LLCの提供するアクセス分析のツールであるGoogle Analyticsを利用した計測を行っております。": "この ページ では、サービス を よくしたり、ページ を もっと よく する ために、Googleが くばっている どうぐ「Google Analytics」を つかって、どのように みなさん が つかって くれているか を みています",
    "Google Analyticsは、当サイトが発行するクッキー (Cookie) を利用して、個人を特定する情報を含まずにWebサイトの利用データ（アクセス状況、トラフィック、閲覧環境など）を収集しております。クッキー (Cookie) の利用に関してはGoogleのプライバシーポリシーと規約に基づいております。": "Google Analytics は、この ページ が だしている クッキーを つかって、あなた が だれか わからない ように した うえで、どのように この ページ が みられているかを、Google の プライバシーポリシー という かんがえかた にそって、データ を あつめています。",
    "取得したデータは Webサイト利用状況の分析、サイト運営者へのレポートの作成、その他のサービスの提供に関わる目的に限り、これを使用します。": "あつめた データ は、この ページ が どのように みられているか、とうきょう と によるレポート を つくること、ほか の サービス を だすか かんがえる ため に だけ、つかいます。",
    "Google Analyticsの利用規約及びプライバシーポリシーに関する説明については、Google Analyticsのサイトをご覧ください。": "Google Analytics の つかいかた、プライバシーポリシー に ついては、Google Analytics の ページ をみて ください",
    "Google Analytics利用規約": "Google Analytics を つかう とき の やくそく",
    "Googleのプライバシーポリシー": "Googleのプライバシーポリシー（あなた の じょうほう を とりあつかう とき の Google の かんがえ、きめていること）",
    "Google Analyticsに関する詳細情報": "Google Analytics に ついて の くわしい はなし",
    "免責事項": "せきにん を もてない こと",
    "当サイトに掲載されている情報の正確性については万全を期していますが、東京都は利用者が当サイトの情報を用いて行う一切の行為について責任を負うものではありません。": "この ページ は、ただしい こと を つたえられるよう、みんな で よく しらべて いますが、この ページ に かいてある こと を もとに あなた が おこなった こうどう に ついて とうきょうとが なにか の せきにん を もつこと が できないこと は わかっていて ください。",
    "また、利用者が当サイトを利用したことにより発生した利用者の損害及び利用者が第三者に与えた損害に対して、責任を負うものではありません。": "この ページ に かいてあること が きっかけで なにか もんだい が おきたり、あなたがだれか に もんだい や トラブル を おこした ばあい、とうきょうとが なにか の せきにん を もつこと が できない ことは わかって いて ください。",
    "当サイトに掲載されている情報は、予告なしに変更又は削除することがあります。": "このページに かいてある ことは、おしらせ なしで、かえたり、けすことが あります",
    "データについて": "データ について",
    "本サイトで公表しているデータは、{catalogWebsite}より誰でも自由にダウンロードが可能です。（データは順次追加予定です）": "ここ に かいてある データ は {catalogWebsite} という ページ から みることができます。（データ は あたらしく ふえていきます）",
    "東京都オープンデータカタログサイト": "とうきょうとオープンデータカタログサイト",
    "ソースコードについて": "この ページ を うごかしている プログラム（コンピュータ が わかる ことば で かかれた もの）",
    "当サイトのソースコードはMITライセンスで公開されており、誰でも自由に利用することができます。": "ここで つかわれている プログラム は だれでも つかってよい ルールで かかれています",
    "詳しくは、{githubRepo}をご確認ください。": "この ページ の プログラミング について くわしく しりたい とき は {githubRepo} を みてください",
    "GitHub リポジトリ": "GitHub の リポジトリ というところ",
    "お問い合わせ先": "といあわせさき（こまったときに きくところ）",
    "東京都生活文化局広報広聴部広報課": "とうきょうと せいかつぶ ぶんかきょく こうほう こうちょうぶ こうほうか",
    "電話": "でんわ"
  }
}
</i18n>

<script>
  import VueMarkdown from 'vue-markdown'

</script>
<script lang="ts">
import TextCard from '@/components/TextCard.vue'
import PageHeader from '@/components/PageHeader.vue'

export default {
  components: {
    TextCard,
    PageHeader
  },
  data() {
    return {
      author: {
        headers: [
          { text: '小组成员', value: 'member'},
          { text: '学号', value: 'work' },
          { text: '联系方式', value: 'contact' },

        ],
        data: [
          {
            member: "陈俊潼",
            work: "10185101210",
            contact: "Bill.Chen@live.com"
          },
          {
            member: "包梁",
            work: "10185101281",
            contact: "964131617@qq.com"
          },
          {
            member: "谢嘉东",
            work: "10185101247",
            contact: "xiejiadong0623@gmail.com"
          }
        ]
    }


    }
  },
  head() {
    return {
      title: '关于'
    }
  }
}
</script>

<style lang="scss">
.About {
  &-Heading {
    @include font-size(30);
    font-weight: normal;
    color: $gray-2;
    margin-bottom: 12px;
  }
  & &-Browser-List {
    // セレクタ指定が&-Browser-List のみだと
    // .v-application ul の設定が勝ってしまい padding-left が24px となってしまうため
    // このようなセレクタ指定としています
    /*list-style: none;*/
    padding: 12px 36px;
  }
}
.cardTable {
  &.v-data-table {
    th {
      padding: 8px 3px;
      height: auto;
      border-bottom: 1px solid $gray-4;
      white-space: nowrap;
      color: $gray-2;
      font-size: 12px;
      &.text-center {
        text-align: center;
      }
    }
    tbody {
      tr {
        color: $gray-1;
        td {
          padding: 8px 10px;
          height: auto;
          font-size: 12px;
          &.text-center {
            text-align: center;
          }
        }
        &:nth-child(odd) {
          td {
            background: rgba($gray-4, 0.3);
          }
        }
        &:not(:last-child) {
          td:not(.v-data-table__mobile-row) {
            border: none;
          }
        }
      }
    }
  }
}
</style>
