enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario (val nome: String) {
    val formacoes = mutableListOf<Formacao>()

    fun matricular(formacao: Formacao) {
        formacoes.add(formacao)

        println("${this.nome} foi matriculado no curso: ${formacao.nome}")
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)

        println("O usuário $usuario foi adicionado.")
    }

    fun conteudos() {
        for (conteudo in conteudos) {
            println(conteudo)
        }
    }
}

fun main() {
    val android = Formacao("Android", listOf(
            ConteudoEducacional("Kotlin", nivel = Nivel.BASICO),
            ConteudoEducacional("Android Studio", nivel = Nivel.BASICO),
            ConteudoEducacional("Noções Básicas", nivel = Nivel.INTERMEDIARIO),
            ConteudoEducacional("JetPack", nivel = Nivel.AVANÇADO)))

    android.conteudos()

    val usuario1 = Usuario("Guilherme")
    usuario1.matricular(android)
}