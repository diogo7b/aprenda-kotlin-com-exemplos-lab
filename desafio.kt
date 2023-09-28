// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { 
    BASICO, INTERMEDIARIO, DIFICIL 
}

enum class TipoConteudo {
    CURSO, IMERSAO, PROJETO
}

data class Usuario(
    val nome: String,
    val email: String,
    var nickname: String?,
    val password: String
    ) {}

data class ConteudoEducacional(
    // Duração deve ser informada em minutos
    val nome: String,
    val tipo: TipoConteudo, 
    val duracaoEmMinutos:Int,
    var nivel: Nivel
    ) {}

data class Formacao(
    val nome: String, 
    val nivel: Nivel,
    val conteudos: MutableList<ConteudoEducacional>
    ) {

    val inscritos = mutableListOf<Usuario>()
    fun matricular(vararg usuario: Usuario):Unit {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        usuario.forEach{
            inscritos.add(it)
        }
    }

    fun listarMatriculados():List<String>{
        val matriculados = inscritos.map{ it.nome }
       	return matriculados
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    //Criação de alunos
    val aluno1 = Usuario(
        "Diogo", 
        "email@email.com", 
        "Di", "kjat55218")
    val aluno2 = Usuario(
        "Manuela", 
        "email@email.com", 
        "", 
        "oilat55218")
    val aluno3 = Usuario(
        "Carlos", 
        "email@email.com", 
        "Cal", 
        "lol5321446")

    //Criação de Conteudos
    val imersao1 = ConteudoEducacional(
        "Implementando POO em Kotlin", 
        TipoConteudo.IMERSAO, 
        120, 
        Nivel.BASICO )
    val curso1 = ConteudoEducacional(
        "Introdução ao Raciocinio Lógico", 
        TipoConteudo.CURSO, 
        60, 
        Nivel.BASICO)
    val curso2 = ConteudoEducacional(
        "Desenvolvendo habilidades 'não-técnicas'", 
        TipoConteudo.CURSO, 
        1800, 
        Nivel.INTERMEDIARIO)
    
    // Criação de Formação
    val formacao1 = Formacao("Formação em Prgramação", Nivel.BASICO, mutableListOf(imersao1, curso1, curso2) )
    
    // Matriculas de alunos
   	formacao1.matricular(aluno1)
   	formacao1.matricular(aluno2,aluno3)

    // Exibir alunos matriculados
    println(formacao1.listarMatriculados())
    
}