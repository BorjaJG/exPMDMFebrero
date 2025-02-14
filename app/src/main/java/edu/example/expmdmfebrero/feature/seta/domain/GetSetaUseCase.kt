package edu.example.expmdmfebrero.feature.seta.domain

class GetSetaUseCase (private val setaRepository: SetaRepository){

    fun execute(idSeta: String){
        return setaRepository.getSeta(idSeta)
    }

}