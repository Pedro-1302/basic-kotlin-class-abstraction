enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Aluno>()

    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
        println("Aluno ${aluno.nome} matriculado na formação ${nome}")
    }

    fun desmatricular(aluno: Aluno) {
        inscritos.remove(aluno)
        println("Aluno ${aluno.nome} desmatriculado da formação ${nome}")
    }
}

data class Aluno(val nome: String, val email: String, val idade: Int)

fun main() {
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 120)
    val kotlinIntermediario = ConteudoEducacional("Avançando em Kotlin com Exceções", 14)
    val kotlinAvancado = ConteudoEducacional("Networking e boas praticas de código", 65)

    val formacaoKotlinDoBasicoAoAvancado = Formacao(
        "Formação em Kotlin (Do básico ao avançado)",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado)
    )

    val alunoPedro = Aluno("Pedro Franco", "pedrofrancodev13@gmail.com", 21)
    val alunaEmily = Aluno("Emily Bárbara Comin", "emilybc.gc@gmail.com", 28)

    formacaoKotlinDoBasicoAoAvancado.matricular(alunoPedro)
    formacaoKotlinDoBasicoAoAvancado.matricular(alunaEmily)
    
    println("Desmatriculando alunos")
    formacaoKotlinDoBasicoAoAvancado.desmatricular(alunoPedro)
    formacaoKotlinDoBasicoAoAvancado.desmatricular(alunaEmily)
}
