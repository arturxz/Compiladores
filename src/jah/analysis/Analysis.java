/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.analysis;

import jah.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAPgr(APgr node);
    void caseAUmDeclZeroOuMaisDecl(AUmDeclZeroOuMaisDecl node);
    void caseAZrDeclZeroOuMaisDecl(AZrDeclZeroOuMaisDecl node);
    void caseAUmCommZeroOuMaisComm(AUmCommZeroOuMaisComm node);
    void caseAZrCommZeroOuMaisComm(AZrCommZeroOuMaisComm node);
    void caseAVariavelDecl(AVariavelDecl node);
    void caseAConstanteDecl(AConstanteDecl node);
    void caseAComVirgulaPosDecl(AComVirgulaPosDecl node);
    void caseASemVirgulaPosDecl(ASemVirgulaPosDecl node);
    void caseARealTipo(ARealTipo node);
    void caseAInteiroTipo(AInteiroTipo node);
    void caseAStringTipo(AStringTipo node);
    void caseANormalVar(ANormalVar node);
    void caseAArrayVar(AArrayVar node);
    void caseAStringValor(AStringValor node);
    void caseAInteiroValor(AInteiroValor node);
    void caseARealValor(ARealValor node);
    void caseAApenasUmComandoMultiplosComm(AApenasUmComandoMultiplosComm node);
    void caseAMaisDeUmComandoMultiplosComm(AMaisDeUmComandoMultiplosComm node);
    void caseAComandoNormalComm(AComandoNormalComm node);
    void caseAComandoLeiaComm(AComandoLeiaComm node);
    void caseAComandoEscrevaComm(AComandoEscrevaComm node);
    void caseAComandoSeComm(AComandoSeComm node);
    void caseAComandoAvalieComm(AComandoAvalieComm node);
    void caseAComandoEnquantoComm(AComandoEnquantoComm node);
    void caseAComandoRepitaComm(AComandoRepitaComm node);
    void caseAComandoParaIteraComm(AComandoParaIteraComm node);
    void caseAComandoParaPassaComm(AComandoParaPassaComm node);
    void caseAComVirgulaPosExpComm(AComVirgulaPosExpComm node);
    void caseASemVirgulaPosExpComm(ASemVirgulaPosExpComm node);
    void caseAFimSe(AFimSe node);
    void caseAFimEnquanto(AFimEnquanto node);
    void caseAInicioPara(AInicioPara node);
    void caseAPassoPara(APassoPara node);
    void caseAFimPara(AFimPara node);
    void caseAFimSimplesFimAvalie(AFimSimplesFimAvalie node);
    void caseASennaoFimFimAvalie(ASennaoFimFimAvalie node);
    void caseADentroSeSimplesSeSenao(ADentroSeSimplesSeSenao node);
    void caseADentroSeSenaoSeSenao(ADentroSeSenaoSeSenao node);
    void caseACasoPosAvalie(ACasoPosAvalie node);
    void caseAAvalieSimplesAvalieSenao(AAvalieSimplesAvalieSenao node);
    void caseAAvalieSenaoAvalieSenao(AAvalieSenaoAvalieSenao node);
    void caseAPosExp(APosExp node);
    void caseAPosExplogica(APosExplogica node);
    void caseAExpAritmeticaInicialExp(AExpAritmeticaInicialExp node);
    void caseAExpLogicaExp(AExpLogicaExp node);
    void caseAValorExpAritmeticaInicial(AValorExpAritmeticaInicial node);
    void caseAExpEntreParentesisExpAritmeticaInicial(AExpEntreParentesisExpAritmeticaInicial node);
    void caseAAritSomaExpAritmeticaInicial(AAritSomaExpAritmeticaInicial node);
    void caseAExpSomaExpAritSoma(AExpSomaExpAritSoma node);
    void caseAAritSubAritSoma(AAritSubAritSoma node);
    void caseAExpSubExpAritSub(AExpSubExpAritSub node);
    void caseAAritMultAritSub(AAritMultAritSub node);
    void caseAExpMulExpAritMult(AExpMulExpAritMult node);
    void caseAAritDivAritMult(AAritDivAritMult node);
    void caseAExpDivExpAritDiv(AExpDivExpAritDiv node);
    void caseAPosExpAritDiv(APosExpAritDiv node);
    void caseAExplogicaEntreParentesisExpLogicaInicial(AExplogicaEntreParentesisExpLogicaInicial node);
    void caseAExplogicaIgualaExpLogicaInicial(AExplogicaIgualaExpLogicaInicial node);
    void caseAExpIgualaExpExplogicaIguala(AExpIgualaExpExplogicaIguala node);
    void caseAExplogicaDiffExplogicaIguala(AExplogicaDiffExplogicaIguala node);
    void caseAExpDiferenteExpExplogicaDiff(AExpDiferenteExpExplogicaDiff node);
    void caseAExplogicaMenorExplogicaDiff(AExplogicaMenorExplogicaDiff node);
    void caseAExpMenorExpExplogicaMenor(AExpMenorExpExplogicaMenor node);
    void caseAExplogicaMenorigualExplogicaMenor(AExplogicaMenorigualExplogicaMenor node);
    void caseAExpMenorIgualExpExplogicaMenorigual(AExpMenorIgualExpExplogicaMenorigual node);
    void caseAExplogicaMaiorExplogicaMenorigual(AExplogicaMaiorExplogicaMenorigual node);
    void caseAExpMaiorExpExplogicaMaior(AExpMaiorExpExplogicaMaior node);
    void caseAExplogicaMaiorIgualExplogicaMaior(AExplogicaMaiorIgualExplogicaMaior node);
    void caseAExpMaiorIgualExpExplogicaMaiorigual(AExpMaiorIgualExpExplogicaMaiorigual node);
    void caseAExplogicaNotExplogicaMaiorigual(AExplogicaNotExplogicaMaiorigual node);
    void caseAPosExpExplogicaMaiorigual(APosExpExplogicaMaiorigual node);
    void caseANaoExplogicaExplogicaNot(ANaoExplogicaExplogicaNot node);
    void caseAExplogicaAndExplogicaNot(AExplogicaAndExplogicaNot node);
    void caseAExplogicaEExplogicaExplogicaAnd(AExplogicaEExplogicaExplogicaAnd node);
    void caseAExplogicaOrExplogicaAnd(AExplogicaOrExplogicaAnd node);
    void caseAExplogicaOuExplogicaExplogicaOr(AExplogicaOuExplogicaExplogicaOr node);
    void caseAExplogicaXorExplogicaOr(AExplogicaXorExplogicaOr node);
    void caseAExplogicaXorExplogicaExplogicaXor(AExplogicaXorExplogicaExplogicaXor node);
    void caseAExplogicaXor(AExplogicaXor node);

    void caseTPrograma(TPrograma node);
    void caseTInicio(TInicio node);
    void caseTFim(TFim node);
    void caseTFimPrograma(TFimPrograma node);
    void caseTLeia(TLeia node);
    void caseTEscreva(TEscreva node);
    void caseTConstante(TConstante node);
    void caseTFaca(TFaca node);
    void caseTAte(TAte node);
    void caseTDe(TDe node);
    void caseTPasso(TPasso node);
    void caseTSenao(TSenao node);
    void caseTEntao(TEntao node);
    void caseTSe(TSe node);
    void caseTCaso(TCaso node);
    void caseTAvalie(TAvalie node);
    void caseTEnquanto(TEnquanto node);
    void caseTPara(TPara node);
    void caseTRepita(TRepita node);
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
    void caseTXor(TXor node);
    void caseTTipoInteiro(TTipoInteiro node);
    void caseTTipoReal(TTipoReal node);
    void caseTTipoString(TTipoString node);
    void caseTTipoBooleano(TTipoBooleano node);
    void caseTVirgula(TVirgula node);
    void caseTPonto(TPonto node);
    void caseTPontoVirgula(TPontoVirgula node);
    void caseTDoisPontos(TDoisPontos node);
    void caseTAbreParentesis(TAbreParentesis node);
    void caseTFechaParentesis(TFechaParentesis node);
    void caseTAbreColchetes(TAbreColchetes node);
    void caseTFechaColchetes(TFechaColchetes node);
    void caseTAtribuicao(TAtribuicao node);
    void caseTAspasSimples(TAspasSimples node);
    void caseTAspasDuplas(TAspasDuplas node);
    void caseTNovaLinha(TNovaLinha node);
    void caseTTab(TTab node);
    void caseTEspaco(TEspaco node);
    void caseTInteiro(TInteiro node);
    void caseTReal(TReal node);
    void caseTString(TString node);
    void caseTBooleano(TBooleano node);
    void caseTId(TId node);
    void caseTComentarioLinha(TComentarioLinha node);
    void caseTComentarioBlocoAbre(TComentarioBlocoAbre node);
    void caseTComentarioBlocoFecha(TComentarioBlocoFecha node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
