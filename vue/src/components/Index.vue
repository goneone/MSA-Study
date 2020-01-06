<template>
  <!-- Material form login -->
  <form>
    <div class="space">

    </div>
    <p class="h4 text-center mb-4">Sign in</p>
    <div class="grey-text">
      <mdb-input label="Your email" icon="envelope" type="email"/>
      <mdb-input label="Your password" icon="lock" type="password"/>
    </div>
    <div class="text-center">
      <mdb-btn>Login</mdb-btn>
    </div>
  </form>
  <!-- Material form login -->
</template>


<script>
  import { mdbInput, mdbBtn } from 'mdbvue';

  export default {
    name: 'Basic',
    components: {
      mdbInput,
      mdbBtn
    },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.space {
  padding: 20px;
}
</style>
