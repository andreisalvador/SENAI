<template>
  <div class="placa">
    <label for="placa">Placa:</label>
    <input type="text" name="placa" id="placa" v-model="txtPlaca" />
    <button @click="search">OK</button>
  </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    return {
      txtPlaca: ''
    }
  },
  methods: {
    search () {
      this.$router.push(`/details/${this.txtPlaca}`)
    }
  }
}
</script>
<style>
</style>
