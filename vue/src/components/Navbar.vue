<template>
  <mdb-navbar color="default-color" dark>
    <mdb-navbar-brand href="https://mdbootstrap.com/">
      Menu
    </mdb-navbar-brand>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <mdb-nav-item href="#" active to="/index">Home</mdb-nav-item>
        <mdb-nav-item href="#" to="/register">Sign up</mdb-nav-item>
        <mdb-nav-item href="#" :class="{active : this.$route.name === 'login'}" to="/login">Sign in</mdb-nav-item>
        <mdb-nav-item href="#" to="/example">Board</mdb-nav-item>
      </mdb-navbar-nav>
      <form>
        <mdb-input type="text" class="text-white" placeholder="Search" aria-label="Search" label navInput waves waves-fixed/>
      </form>
    </mdb-navbar-toggler>
  </mdb-navbar>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbInput, } from 'mdbvue';
  export default {
    name: 'NavbarPage',
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbInput
    }
  }
</script>

<style lang="css" scoped>
</style>
