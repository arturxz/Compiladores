/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.analysis;

import linguagem.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseACabecalho(ACabecalho node);

    void caseTPrograma(TPrograma node);
    void caseTInicio(TInicio node);
    void caseTFim(TFim node);
    void caseTFimPrograma(TFimPrograma node);
    void caseTLeia(TLeia node);
    void caseTEscreva(TEscreva node);
    void caseTSe(TSe node);
    void caseTSenao(TSenao node);
    void caseTCaso(TCaso node);
    void caseTAvalie(TAvalie node);
    void caseTEnquanto(TEnquanto node);
    void caseTPara(TPara node);
    void caseTSoma(TSoma node);
    void caseTSub(TSub node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTMaior(TMaior node);
    void caseTMenor(TMenor node);
    void caseTIgual(TIgual node);
    void caseTMaiorIgual(TMaiorIgual node);
    void caseTMenorIgual(TMenorIgual node);
    void caseTDiferente(TDiferente node);
    void caseTNao(TNao node);
    void caseTE(TE node);
    void caseTOu(TOu node);
    void caseTAtribuicao(TAtribuicao node);
    void caseTAbreParentesis(TAbreParentesis node);
    void caseTFechaParentesis(TFechaParentesis node);
    void caseTAbreColchetes(TAbreColchetes node);
    void caseTFechaColchetes(TFechaColchetes node);
    void caseTPonto(TPonto node);
    void caseTVirgula(TVirgula node);
    void caseTPontoEVirgula(TPontoEVirgula node);
    void caseTDoisPontos(TDoisPontos node);
    void caseTAspasSimples(TAspasSimples node);
    void caseTAspasDuplas(TAspasDuplas node);
    void caseTNovaLinha(TNovaLinha node);
    void caseTEspaco(TEspaco node);
    void caseTTab(TTab node);
    void caseTNumero(TNumero node);
    void caseTId(TId node);
    void caseTComentarioBlocoAbre(TComentarioBlocoAbre node);
    void caseTCaracteresPermitidos(TCaracteresPermitidos node);
    void caseTComentarioBlocoFecha(TComentarioBlocoFecha node);
    void caseTComentarioLinha(TComentarioLinha node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
