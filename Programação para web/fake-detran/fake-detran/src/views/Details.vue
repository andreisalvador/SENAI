<template>
  <div class="details">
    <div>
      <label for="data">Data:</label>
      <input disabled type="text" name="data" id="data" v-model="data" />
    </div>
    <div>
      <label for="local">Local:</label>
      <input disabled type="text" name="local" id="local" v-model="local" />
    </div>
    <div>
      <label for="tipo">Tipo:</label>
      <input disabled type="text" name="tipo" id="tipo" v-model="tipo" />
    </div>
    <div>
      <label for="hora">Hora:</label>
      <input disabled type="text" name="hora" id="hora" v-model="hora" />
    </div>
    <div>
      <label for="valor" v-if="valor">Valor:</label>
      <input disabled v-if="valor" type="text" name="valor" id="valor" v-model="valor" />
    </div>
    <div>
      <label v-if="vel_max" for="vel_max" style="color: red">Velocidade Maxima </label>
      <span v-if="vel_max" style="color: red">{{vel_max}} Km!!</span>
    </div>
    <button @click="goToMain">Nova consulta</button>
  </div>
</template>

<script>
import { placas } from '../resources/placas.json'

export default {
  name: 'Details',
  data () {
    return {
      data: '',
      local: '',
      hora: '',
      tipo: '',
      valor: '',
      vel_max: ''
    }
  },
  methods: {
    goToMain () {
      this.$router.push('/')
    }
  },
  created: function () {
    const selectedPlaca = placas.find(x => x.placa === this.$route.params.placa)
    const [date, hour] = selectedPlaca.dados_infracao.datahora.split(' ')
    this.data = date
    this.tipo = selectedPlaca.dados_infracao.tipo
    this.local = selectedPlaca.localidade
    this.valor = selectedPlaca.dados_infracao.valor
    this.vel_max = selectedPlaca.dados_infracao.vel_maxima
    this.hora = hour
  }
}
</script>

<style>
</style>
