/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.parser;

import linguagem.node.*;
import linguagem.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTPrograma(@SuppressWarnings("unused") TPrograma node)
    {
        this.index = 0;
    }

    @Override
    public void caseTInicio(@SuppressWarnings("unused") TInicio node)
    {
        this.index = 1;
    }

    @Override
    public void caseTFim(@SuppressWarnings("unused") TFim node)
    {
        this.index = 2;
    }

    @Override
    public void caseTFimPrograma(@SuppressWarnings("unused") TFimPrograma node)
    {
        this.index = 3;
    }

    @Override
    public void caseTLeia(@SuppressWarnings("unused") TLeia node)
    {
        this.index = 4;
    }

    @Override
    public void caseTEscreva(@SuppressWarnings("unused") TEscreva node)
    {
        this.index = 5;
    }

    @Override
    public void caseTSe(@SuppressWarnings("unused") TSe node)
    {
        this.index = 6;
    }

    @Override
    public void caseTSenao(@SuppressWarnings("unused") TSenao node)
    {
        this.index = 7;
    }

    @Override
    public void caseTCaso(@SuppressWarnings("unused") TCaso node)
    {
        this.index = 8;
    }

    @Override
    public void caseTAvalie(@SuppressWarnings("unused") TAvalie node)
    {
        this.index = 9;
    }

    @Override
    public void caseTEnquanto(@SuppressWarnings("unused") TEnquanto node)
    {
        this.index = 10;
    }

    @Override
    public void caseTPara(@SuppressWarnings("unused") TPara node)
    {
        this.index = 11;
    }

    @Override
    public void caseTSoma(@SuppressWarnings("unused") TSoma node)
    {
        this.index = 12;
    }

    @Override
    public void caseTSub(@SuppressWarnings("unused") TSub node)
    {
        this.index = 13;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 14;
    }

    @Override
    public void caseTDiv(@SuppressWarnings("unused") TDiv node)
    {
        this.index = 15;
    }

    @Override
    public void caseTMaior(@SuppressWarnings("unused") TMaior node)
    {
        this.index = 16;
    }

    @Override
    public void caseTMenor(@SuppressWarnings("unused") TMenor node)
    {
        this.index = 17;
    }

    @Override
    public void caseTIgual(@SuppressWarnings("unused") TIgual node)
    {
        this.index = 18;
    }

    @Override
    public void caseTMaiorIgual(@SuppressWarnings("unused") TMaiorIgual node)
    {
        this.index = 19;
    }

    @Override
    public void caseTMenorIgual(@SuppressWarnings("unused") TMenorIgual node)
    {
        this.index = 20;
    }

    @Override
    public void caseTDiferente(@SuppressWarnings("unused") TDiferente node)
    {
        this.index = 21;
    }

    @Override
    public void caseTNao(@SuppressWarnings("unused") TNao node)
    {
        this.index = 22;
    }

    @Override
    public void caseTE(@SuppressWarnings("unused") TE node)
    {
        this.index = 23;
    }

    @Override
    public void caseTOu(@SuppressWarnings("unused") TOu node)
    {
        this.index = 24;
    }

    @Override
    public void caseTAtribuicao(@SuppressWarnings("unused") TAtribuicao node)
    {
        this.index = 25;
    }

    @Override
    public void caseTAbreParentesis(@SuppressWarnings("unused") TAbreParentesis node)
    {
        this.index = 26;
    }

    @Override
    public void caseTFechaParentesis(@SuppressWarnings("unused") TFechaParentesis node)
    {
        this.index = 27;
    }

    @Override
    public void caseTAbreColchetes(@SuppressWarnings("unused") TAbreColchetes node)
    {
        this.index = 28;
    }

    @Override
    public void caseTFechaColchetes(@SuppressWarnings("unused") TFechaColchetes node)
    {
        this.index = 29;
    }

    @Override
    public void caseTPonto(@SuppressWarnings("unused") TPonto node)
    {
        this.index = 30;
    }

    @Override
    public void caseTVirgula(@SuppressWarnings("unused") TVirgula node)
    {
        this.index = 31;
    }

    @Override
    public void caseTPontoEVirgula(@SuppressWarnings("unused") TPontoEVirgula node)
    {
        this.index = 32;
    }

    @Override
    public void caseTDoisPontos(@SuppressWarnings("unused") TDoisPontos node)
    {
        this.index = 33;
    }

    @Override
    public void caseTAspasSimples(@SuppressWarnings("unused") TAspasSimples node)
    {
        this.index = 34;
    }

    @Override
    public void caseTAspasDuplas(@SuppressWarnings("unused") TAspasDuplas node)
    {
        this.index = 35;
    }

    @Override
    public void caseTNovaLinha(@SuppressWarnings("unused") TNovaLinha node)
    {
        this.index = 36;
    }

    @Override
    public void caseTEspaco(@SuppressWarnings("unused") TEspaco node)
    {
        this.index = 37;
    }

    @Override
    public void caseTTab(@SuppressWarnings("unused") TTab node)
    {
        this.index = 38;
    }

    @Override
    public void caseTNumero(@SuppressWarnings("unused") TNumero node)
    {
        this.index = 39;
    }

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 40;
    }

    @Override
    public void caseTComentarioBlocoAbre(@SuppressWarnings("unused") TComentarioBlocoAbre node)
    {
        this.index = 41;
    }

    @Override
    public void caseTCaracteresPermitidos(@SuppressWarnings("unused") TCaracteresPermitidos node)
    {
        this.index = 42;
    }

    @Override
    public void caseTComentarioBlocoFecha(@SuppressWarnings("unused") TComentarioBlocoFecha node)
    {
        this.index = 43;
    }

    @Override
    public void caseTComentarioLinha(@SuppressWarnings("unused") TComentarioLinha node)
    {
        this.index = 44;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 45;
    }
}
