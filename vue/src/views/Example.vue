<template>

<div class="col-md-12">
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" name="title" v-model="title" placeholder="제목을 입력하세요">
            </div>
            <div class="form-group">
                <label for="author"> 작성자 </label>
                <input type="text" class="form-control" name="author" v-model="author" placeholder="작성자를 입력하세요">
            </div>
            <div class="form-group">
                <label for="content"> 내용 </label>
                <textarea class="form-control" name="content" v-model="content" placeholder="내용을 입력하세요"></textarea>
            </div>
        <button v-on:click="registerTest2" type="button" class="btn btn-primary">등록</button>
        <a href="/" role="button" class="btn btn-secondary">취소</a>
        </form>
    </div>
</div>
</template>

<script>
import axios from 'axios' // 아까 받은 axios 패키지를 사용하기 위해 import한다


export default {
  mounted() {
    console.log("Component mounted")
  },
  name: 'app',
  data() {
    return {
      title: '',
      author: '',
      content: '',
    };
  },
  methods: {
    registerTest2(e) {
      e.preventDefault();
      alert("시작합니다")
      axios.post('http://localhost:8081/registerTest',
        { title: this.title,
          author:this.author,
          content:this.content
        })
        .then(response => {
          console.warn(response)
          this.result = response.data
          this.no = response.data.no
      }).catch((ex) => {
          console.warn("ERROR!!!!! : ",ex)
      })
    }
  }
}
</script>
