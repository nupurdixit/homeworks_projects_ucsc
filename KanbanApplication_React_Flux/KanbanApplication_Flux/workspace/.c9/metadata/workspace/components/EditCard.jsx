{"filter":false,"title":"EditCard.jsx","tooltip":"/components/EditCard.jsx","undoManager":{"mark":0,"position":0,"stack":[[{"start":{"row":0,"column":0},"end":{"row":62,"column":42},"action":"remove","lines":["import React from 'react';","import {Container} from 'flux/utils';","","import CardForm from './CardForm.jsx';","import DraftStore from '../flux/stores/DraftStore';","import CardStore from '../flux/stores/CardStore';","import CardActionCreators from '../flux/actions/CardActionCreators';","","class EditCard extends React.Component {","\t  static getStores() {","\t    return [DraftStore];","\t  }","\t","\t  static calculateState(prevState) {","\t    return {","\t      draft: DraftStore.getState(),","\t    };","\t  }","\t  ","\tcomponentDidMount() {","\t\tlet card = this;","\t\tsetTimeout(() => {","\t\t\tCardActionCreators.createDraft(CardStore.getCard(card.props.params.card_id));","\t\t}, 0);","\t\t","\t}","","\thandleChange(field, value) {","\t\tCardActionCreators.updateDraft(field,value);","\t\t//this.setState({[field]: value});","\t}","","\thandleSubmit(evt) {","\t//\tlet card=this;","\t\tevt.preventDefault();","\t\tCardActionCreators.updateCard(CardStore.getCard(this.props.params.card_id),this.state.draft);","\t\t//this.props.cardCallbacks.update(this.state);","\t\tthis.context.router.push('/');","\t}","","\thandleClose(e) {","\t\tthis.context.router.push('/');","\t}","    ","    render() {","        return (","            <CardForm draftCard={this.state.draft}","\t\t\t\t\t  buttonLabel=\"Edit Card\"","\t\t\t\t\t  handleChange={this.handleChange.bind(this)}","\t\t\t\t\t  handleSubmit={this.handleSubmit.bind(this)}","\t\t\t\t\t  handleClose={this.handleClose.bind(this)}","\t\t\t/>","        )","    }","}","","","","EditCard.contextTypes = {","\trouter: React.PropTypes.object.isRequired","};","","export default Container.create(EditCard);"],"id":400},{"start":{"row":0,"column":0},"end":{"row":59,"column":42},"action":"insert","lines":["import React from 'react';","import {Container} from 'flux/utils';","","import CardForm from './CardForm.jsx';","import DraftStore from '../flux/stores/DraftStore';","import CardStore from '../flux/stores/CardStore';","import CardActionCreators from '../flux/actions/CardActionCreators';","","class EditCard extends React.Component {","\t  static getStores() {","\t    return [DraftStore];","\t  }","\t","\t  static calculateState(prevState) {","\t    return {","\t      draft: DraftStore.getState(),","\t    };","\t  }","\t  ","\tcomponentDidMount() {","\t\tlet card = this;","\t\tsetTimeout(() => {","\t\t\tCardActionCreators.createDraft(CardStore.getCard(card.props.params.card_id));","\t\t}, 0);","\t}","","\thandleChange(field, value) {","\t\tCardActionCreators.updateDraft(field, value);","\t}","","\thandleSubmit(evt) {","\t\tevt.preventDefault();","\t\tCardActionCreators.updateCard(","\t\t\tCardStore.getCard(this.props.params.card_id),","\t\t\tthis.state.draft","\t\t)","\t\tthis.context.router.push('/');","\t}","","\thandleClose(e) {","\t\tthis.context.router.push('/');","\t}","    ","    render() {","        return (","            <CardForm draftCard={this.state.draft}","\t\t\t\t\t  buttonLabel=\"Save Card\"","\t\t\t\t\t  handleChange={this.handleChange.bind(this)}","\t\t\t\t\t  handleSubmit={this.handleSubmit.bind(this)}","\t\t\t\t\t  handleClose={this.handleClose.bind(this)}","\t\t\t/>","        )","    }","}","","EditCard.contextTypes = {","\trouter: React.PropTypes.object.isRequired","};","","export default Container.create(EditCard);"]}]]},"ace":{"folds":[],"scrolltop":183,"scrollleft":0,"selection":{"start":{"row":59,"column":42},"end":{"row":59,"column":42},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":0},"timestamp":1471723958832,"hash":"7356d0ae516ef0964d4a02a913677b8a50a4caef"}