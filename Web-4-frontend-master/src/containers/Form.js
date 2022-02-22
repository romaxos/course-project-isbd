import React from "react";
import {connect} from 'react-redux';
import {Button} from "primereact/button";
import {InputText} from "primereact/inputtext";
import {getTable, sendPoint, setMessageR, setMessageX, setMessageY, setR, setX, setY} from "../actions/pageActions";
import {Checkbox} from "primereact/checkbox";
import {Result} from "../components/Table";
import {logout} from "../actions/userActions";

class InputField extends React.Component{
    constructor(props){
        super(props);
        this.chooseX = this.chooseX.bind(this);
        this.chooseY = this.chooseY.bind(this);
        this.chooseR = this.chooseR.bind(this);
        this.goFuckingBack = this.goFuckingBack.bind(this);
        this.submitPoint = this.submitPoint.bind(this);
        this.setOffX = this.setOffX.bind(this);
    }

    chooseX(e){
        this.props.setX(e.target.value);
        this.props.setMessageX("");

    }

    chooseY(e){
        this.props.setMessageY("");
        this.props.setY(e.target.value);
    }

    chooseR(e){
        this.props.setMessageR("");
        this.props.setR(e.target.value);
        // document.getElementById('r5').checked = 'true';
    }

    sendPoint(x,y,r){
        console.log("X: "+ x + "\nY: " + y + "\nR: " +r);
        let butch = {
            x: x,
            y: y,
            r: r,
        };
        this.props.sendPoint(butch);
    }

    submitPoint(e){
        this.props.setMessageX("");
        this.props.setMessageY("");
        this.props.setMessageR("");
        let flag = true;
        let x = this.props.page.x;
        if(x=="" || x == null){
            this.props.setMessageX("Вы не ввели X");
            flag = false;
        }else {
            if(!/^(-?\d+)([.,]\d+)?$/.test(x)) {
                this.props.setMessageX("X должен быть числом")
            }else {
                x = x.replace(',', '.');
                x = Number(x);
                if(x >= 5 || x <= -3) {
                    flag = false;
                    this.props.setMessageX("X должен быть в инетрвале (-3;5)");
                }
            }
        }
        let y = this.props.page.y;
        if(y=="" || y==null){
            this.props.setMessageY("Вы не ввели Y");
            flag = false;
        } else {
            if(!/^(-?\d+)([.,]\d+)?$/.test(y)) {
                this.props.setMessageY("Y должен быть числом");
            } else {
                y = y.replace(',','.');
                y = Number(y);
                if (y >= 5 || y <= -3) {
                    flag = false;
                    this.props.setMessageY("Y должен быть в интервале (-3;5)");
                }
            }
        }
        let r = this.props.page.r;
        if (r=="" || r == null) {
            this.props.setMessageR("Вы не ввели R");
            flag = false;
        }else {
            if(!/^(-?\d+)([.,]\d+)?$/.test(r)) {
                this.props.setMessageR("R должен быть числом");
            }else {
                r = r.replace(',', '.');
                r = Number(r);
                if (r < 0) {
                    flag = false;
                    this.props.setMessageR("R не может быть отрицательным");
                } else if (r >= 5) {
                    flag = false;
                    this.props.setMessageR("R должен быть в инетрвале (-1; 5)");
                }
            }
        }
        console.log(flag);
        if(flag){
            this.sendPoint(this.props.page.x, this.props.page.y, this.props.page.r)
        }
    }

    goFuckingBack(e){
        this.props.logout()
    }

    setOffX(){
        this.setState({
            cbm3: false,
            cbm2: false,
            cbm1: false,
            cb0: false,
            cb1: false,
            cb2: false,
            cb3: false,
            cb4: false,
            cb5: false,
        })
    }

    render() {
        const {page,style} = this.props;
        return(
            <div className="form" width={ page.pageWidth} style={style.style.formView.block}>
                {/*<br/>*/}
                <div style={style.style.formView.divHeaderInForm}>
                    <Button label={"Logout"} onClick={this.goFuckingBack} style={style.style.formView.logout}/>
                    <p style={style.style.formView.pHeader}>Форма</p>
                </div>

                <div style={style.style.formView.divX}>
                    <p style={style.style.formView.descriptionX} >Введите X</p>
                    <input maxLength={10} style={style.style.formView.fieldX} onChange={this.chooseX} id={"X"}/>
                    <div className={"messageX"} style={style.style.formView.message}>
                        {page.x == "" ? <br/> : page.messageX}
                    </div>
                </div>
                <div>

                </div>
                <div style={style.style.formView.divY}>
                    <p style={style.style.formView.descriptionY}>Введите Y</p>
                    <input maxLength={10} style={style.style.formView.fieldY} onChange={this.chooseY} id={"Y"}/>
                    <div className={"messageY"} style={style.style.formView.message}>
                        {page.y == "" ? <br/> : page.messageY}
                    </div>
                </div>
                <div style={style.style.formView.divR}>
                    <p style={style.style.formView.descriptionR}>Введите R</p>
                    <input maxLength={10} style={style.style.formView.fieldR} onChange={this.chooseR} id={"R"}/>
                    <div className={"messageR"} style={style.style.formView.message}>
                        {page.messageR == "" ? <br/> : page.messageR}
                    </div>
                </div>
                <div style={style.style.formView.divSubmit} >
                    <Button label="Send" type={"submit"} onClick={this.submitPoint} style={style.style.formView.send} />
                </div>

                <Result table={page.table} style={style} />
            </div>
        )
    }
}

const mapStateToProps = store => {
     return{
         page: store.page,
         style: store.style
     }
}

const mapDispatchToProps = dispatch => {
    return{
        setR: r => dispatch(setR(r)),
        setX: x => dispatch(setX(x)),
        setY: y => dispatch(setY(y)),
        setMessageX: message => dispatch(setMessageX(message)),
        setMessageY: message => dispatch(setMessageY(message)),
        setMessageR: message => dispatch(setMessageR(message)),
        getTable: () => dispatch(getTable()),
        logout: () => dispatch(logout()),
        sendPoint: butch => dispatch(sendPoint(butch))
    }
}

export default connect (mapStateToProps,mapDispatchToProps)(InputField)