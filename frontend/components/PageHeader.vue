<template>
  <div class="header mb-3">
    <h2 class="pageTitle">
      <v-icon size="40" class="mr-2">
        {{ icon }}
      </v-icon>
      {{ title }}
    </h2>
<!--    <div class="date">-->
<!--      <span>{{ $t('最終更新') }} </span>-->
<!--      <time :datetime="formattedDate">{{ date }}</time>-->
<!--    </div>-->
<!--    <div v-if="!['ja', 'ja-basic'].includes($i18n.locale)" class="annotation">-->
<!--      <span>{{ $t('注釈') }} </span>-->
<!--    </div>-->
  </div>
</template>

<i18n>
{
  "ja": {
    "最終更新": "最終更新",
    "注釈" : "This is a provisional translation. Please be aware that there may be mistranslations."
  },
  "en": {
    "最終更新": "Last update",
    "注釈" : "This is a provisional translation. Please be aware that there may be mistranslations."
  },
  "zh-cn": {
    "最終更新": "最后更新",
    "注釈" : "This is a provisional translation. Please be aware that there may be mistranslations."
  },
  "zh-tw": {
    "最終更新": "上次更新",
    "注釈" : "This is a provisional translation. Please be aware that there may be mistranslations."
  },
  "ko": {
    "最終更新": "최종갱신",
    "注釈" : "This is a provisional translation. Please be aware that there may be mistranslations."
  },
  "ja-basic": {
    "最終更新": "さいごに いちばん あたらしくなおした とき",
    "注釈" : "This is a provisional translation. Please be aware that there may be mistranslations."
  }
}
</i18n>

<script>
import { convertDatetimeToISO8601Format } from '@/utils/formatDate'

export default {
  props: {
    title: {
      type: String,
      required: true,
      default: ''
    },
    icon: {
      type: String,
      required: false,
      default: ''
    },
    date: {
      type: String,
      required: false,
      default: ''
    }
  },
  data() {
    const formattedDate = convertDatetimeToISO8601Format(this.date)
    return { formattedDate }
  }
}
</script>

<style lang="scss">
.header {
  display: flex;
  align-items: flex-end;
  flex-wrap: wrap;
}
.pageTitle {
  display: flex;
  align-items: center;
  font-size: 1.875rem;
  line-height: 1;
  font-weight: normal;
  margin: 0 0.5em 0 0;
  @include lessThan($small) {
    font-size: 1.25rem;
  }
}
.date {
  font-size: 0.875rem;
  color: $gray-3;
}
.annotation {
  font-size: 0.75rem;
  color: $gray-3;
}
@include largerThan($small) {
  .annotation {
    margin: 0 0 0 auto;
  }
}
</style>
