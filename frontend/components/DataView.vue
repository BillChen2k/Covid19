<template>
  <v-card class="DataView">
    <div class="DataView-Inner">
      <div class="DataView-Content">
        <div
          class="DataView-TitleContainer"
          :class="!!$slots.infoPanel ? 'with-infoPanel' : ''"
        >
          <h3 :id="titleId" class="DataView-Title">
            {{ title }}
          </h3>
          <div>
            <slot name="button" />
          </div>
        </div>
        <slot name="infoPanel" />
      </div>
      <div
        :class="
          $vuetify.breakpoint.xs
            ? 'DataView-CardTextForXS'
            : 'DataView-CardText'
        "
      >
        <slot />
      </div>
      <v-footer class="DataView-Footer">
        <time :datetime="date">{{ $t('{date} 更新', { date }) }}</time>

          {{ $t('オープンデータへのリンク') }}

        </a>
      </v-footer>
    </div>
  </v-card>
</template>

<i18n>
{
  "ja": {
    "{date} 更新": "{date} 更新",
    "オープンデータへのリンク": "オープンデータへのリンク"
  },
  "en": {
    "{date} 更新": "Last update: {date}",
    "オープンデータへのリンク": "Link to Open Data"
  },
  "zh-cn": {
    "{date} 更新": "{date} 更新",
    "オープンデータへのリンク": "由于不完整的病人公开信息数据，部分数据是为展示功能而随机产生"
  },
  "zh-tw": {
    "{date} 更新": "{date} 更新",
    "オープンデータへのリンク": "開放資料連結"
  },
  "ko": {
    "{date} 更新": "{date} 갱신",
    "オープンデータへのリンク": "공공데이터에의 링크"
  },
  "ja-basic": {
    "{date} 更新": "{date} に あたらしく しました",
    "オープンデータへのリンク": "オープンデータ という ページを みたいとき"
  }
}
</i18n>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { convertDatetimeToISO8601Format } from '@/utils/formatDate'

@Component
export default class DataView extends Vue {
  @Prop() private title!: string
  @Prop() private titleId!: string
  @Prop() private date!: string
  @Prop() private url!: string
  @Prop() private info!: any // FIXME expect info as {lText:string, sText:string unit:string}

  formattedDate: string = convertDatetimeToISO8601Format(this.date)
}
</script>

<style lang="scss">
.DataView {
  &-Content {
    display: flex;
    justify-content: space-between;
  }
  &-DataInfo {
    position: absolute;
    top: 25px;
    right: 25px;
    &-summary {
      color: $gray-2;
      font-family: Hiragino Sans;
      font-style: normal;
      font-size: 30px;
      line-height: 30px;
      white-space: nowrap;
      &-unit {
        font-size: 0.6em;
        width: 100%;
      }
    }
    &-date {
      font-size: 12px;
      line-height: 12px;
      color: $gray-3;
      width: 100%;
      display: inline-block;
    }
  }
}
.DataView {
  &-Inner {
    display: flex;
    flex-flow: column;
    justify-content: space-between;
    padding: 22px;
    height: 100%;
  }
  &-TitleContainer {
    display: flex;
    flex-flow: column;
    color: $gray-2;
    &.with-infoPanel {
      width: calc(100% - 11em);
    }
  }
  &-Title {
    margin-bottom: 5px;
    font-size: 1.25rem;
    line-height: 1.5;
    font-weight: normal;
  }
  &-CardText {
    margin: 30px 0;
  }
  &-CardTextForXS {
    margin-bottom: 46px;
    margin-top: 70px;
  }
  &-Footer {
    @include font-size(12);
    padding: 0 !important;
    justify-content: space-between;
    flex-direction: row-reverse;
    color: $gray-3 !important;
    text-align: right;
    background-color: $white !important;
    .OpenDataLink {
      text-decoration: none;
      .ExternalLinkIcon {
        vertical-align: text-bottom;
      }
    }
  }
}
</style>
