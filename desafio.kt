// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
    val nivel: Nivel
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome} (${it.email})") }
    }
}

fun main() {
    // Criando usuários
    val usuario1 = Usuario("Hebert", "hebert@email.com")
    val usuario2 = Usuario("Ana", "ana@email.com")

    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 90)
    val poo = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val estruturas = ConteudoEducacional("Estruturas de Dados", 100)

    // Criando formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        conteudos = listOf(kotlinBasico, poo, estruturas),
        nivel = Nivel.INTERMEDIARIO
    )

    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Listando inscritos
    formacaoKotlin.listarInscritos()
}
