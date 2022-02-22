import React from 'react';
import {connect} from 'react-redux';
import {setMessageR,sendPoint} from "../actions/pageActions";

class Canvas extends React.Component{
    constructor(props){
        super(props);
        this.clickCanvas = this.clickCanvas.bind(this);
    }

    drawCanvas(){
        const canvas = this.refs.canvas;
        const ctx = canvas.getContext('2d');
        drawBase(ctx,this.props.page.r,this.refs.canvas.width);
        makeDots(ctx,this.props.page.table,this.props.page.r, this.refs.canvas.width)

    }

    sendPoint(x,y,r){
        console.log("X: "+ x + "\nY: " + y + "\nR: " +r);
        let butch = {
            x: x,
            y: y,
            r: r
        };
        this.props.sendPoint(butch);
    }

    componentDidMount() {
        this.drawCanvas();
    }

    componentDidUpdate() {
        this.drawCanvas();
    }

    clickCanvas(e){
        this.props.setMessageR("");
        if (this.props.page.r === 0){
            this.props.setMessageR('Пожалуйста введите R');
        }else {
            let width = this.refs.canvas.width;
            let size = window.screen.availWidth;
            let r = this.props.page.r;
            let x = ((e.pageX - this.props.page.mL)-width/2)/(width/12);
            // let x = (e.offsetX - width/2)/(width/12);
            let y = -((e.pageY-this.props.page.mT)-width/2)/(width/12);   // +5.8 может сработать
            if (this.props.page.deviceType === "phone" && size <= 870 && size >= 850) y = y - 2.0;          //ok
            else if (this.props.page.deviceType === "phone" && size <= 849 && size >= 800) y = y - 2.11;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 799 && size >= 750) y = y - 2.24;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 749 && size >= 700) y = y - 2.395;   //ok
            else if (this.props.page.deviceType === "phone" && size <= 699 && size >= 650) y = y - 2.58;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 649 && size >= 600) y = y - 2.79;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 599 && size >= 550) y = y - 3.029;   //ok
            else if (this.props.page.deviceType === "phone" && size <= 549 && size >= 500) y = y - 3.33;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 499 && size >= 450) y = y - 3.69;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 449 && size >= 400) y = y - 3.48;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 399 && size >= 350) y = y - 3.97;    //ok
            else if (this.props.page.deviceType === "phone" && size <= 349 && size >= 300) y = y - 4.6;     //ok
            else if (this.props.page.deviceType === "phone" && size <= 299 && size >= 250) y = y - 3.447;   //ok
            else if (this.props.page.deviceType === "phone" && size <= 249 && size >= 200) y = y - 4.33;    //ok



            if (this.props.page.deviceType === 'tablet' && size >= 871 && size <= 887) y = y + 6.03;
            else if (this.props.page.deviceType === 'tablet' && size >= 888 && size <= 925) y = y + 5.8;
            else if (this.props.page.deviceType === 'tablet' && size >= 926 && size <= 975) y = y + 5.70;
            else if (this.props.page.deviceType === 'tablet' && size >= 976 && size <= 1000) y = y + 3.88;
            else if (this.props.page.deviceType === 'tablet' && size >= 1001 && size <= 1024) y = y + 3.79;

            // if (this.props.page.deviceType === "tablet") y = y + 6.54;


            // let y = -(e.offsetY - width/2)/(width/12);
            // console.log("X: "+x+ "\nY: " + y +"\n R:" +r)
            this.sendPoint(x,y,r);
        }
    }


    render() {
        const {style,page} = this.props;
        return(
            <div>
                <canvas ref='canvas' onClick={this.clickCanvas} width={page.canvasWidth} height={page.canvasWidth} style={style.style.canvas}/>
            </div>
        )
    }
}

function drawBase(ctx,R,width){
    R=width*R/12;
    // console.log("Draw...");
    ctx.lineWidth = 2/450*width;
    ctx.fillStyle = "rgba(255,255,255,1)"
    // ctx.fillStyle = "#FF0";

    ctx.fillRect(0,0,width,width);              // весь квадратик))))

    ctx.fillStyle="#6c4480";
    // ctx.fillRect(width/2-R/2,width/2-R,R/2,R);  // прямоугольник во второй четверти
    ctx.fillRect(width/2-R, width/2, R, R/2)

    /* полукруг четвертая четверть */
    ctx.beginPath();
    ctx.arc(width/2+1,width/2+1,R/2,Math.PI*0.5,Math.PI*1.5,false);
    ctx.lineTo(width/2+1,width/2+1);
    ctx.closePath();
    ctx.fill();

    // /* треугольник первая четверть */
    // ctx.beginPath();
    // ctx.moveTo(width/2 +0.5,width/2+1);
    // ctx.lineTo(width/2 +0.5 +R/2,width/2+1);
    // ctx.lineTo(width/2+0.5,width/2+1-R/2);
    // ctx.closePath();
    // ctx.fill();

    /* треугольник */
    ctx.beginPath();
    ctx.moveTo(width/2+0.5, width/2+1);
    ctx.lineTo(width/2+0.5+R, width/2+1)
    ctx.lineTo(width/2+0.5, width/2+1+R/2);
    ctx.closePath();
    ctx.fill();



    /* ось y */
    ctx.beginPath();
    ctx.moveTo(width/2+1,width);
    ctx.lineTo(width/2+1,0);
    ctx.moveTo(22*width/45,width/30);
    ctx.lineTo(width/2+1,0);
    ctx.lineTo(77*width/150,width/30);

    /* ось x */
    ctx.moveTo(0,width/2+1);
    ctx.lineTo(width,width/2+1);
    ctx.moveTo(29*width/30,22*width/45);
    ctx.lineTo(width,width/2+1);
    ctx.lineTo(29*width/30,77*width/150);

    /* штрихи */
    for (let i=width/12; i<=(11*width/12);i+=width/24){
        ctx.moveTo(i,22*width/45);
        ctx.lineTo(i,77*width/150);
        ctx.moveTo(22*width/45,i);
        ctx.lineTo(77*width/150,i);
    }
    /* штрихи */
    for (let j=width/12;j<=(11*width/12);j+=width/12){
        ctx.moveTo(j,217*width/450);
        ctx.lineTo(j,234*width/450);
        ctx.moveTo(217*width/450,j);
        ctx.lineTo(234*width/450,j);
    }
    ctx.stroke();
    ctx.font = 40/450*width;
    ctx.font = " bold Arial black";
    ctx.fillText("x",11*width/12,17*width/30);
    ctx.fillText("y",49*width/90,width/30);
}


// вот тут нужно будет сделать так что бы все точки рисовались разного цвета при смене радиуса
function makeDots(ctx, table, r, width) {
    // console.log("Draw points")
    for(const dot of table){

        let flag = false;


        /* если сделать тут вместо dot.r просто r то будет зависеть чисто от радиуса (на всякий случай если надо будет поменять что то ) */
        if (dot.x <= 0 && dot.y >= 0) {         // круг
            flag = Math.pow(dot.x, 2) + Math.pow(dot.y, 2) <= Math.pow(dot.r/2, 2);
        }
        if (dot.x <= 0 && dot.y <= 0) {         // прямоугольник
            flag = Math.abs(dot.x) <= dot.r && Math.abs(dot.y) <= dot.r/2;
        }
        if (dot.x >= 0 && dot.y <= 0) {
            flag = dot.x <= dot.r && Math.abs(dot.y) <= (dot.r / 2) && dot.y >= (dot.x / 2) - (dot.r / 2);
        }


        if (flag){
            paintPoint(ctx,Number(dot.x),Number(dot.y),'pink',width);
        }
        else
            paintPoint(ctx,Number(dot.x),Number(dot.y),'#2A2A2A',width);
    }
}


function paintPoint(ctx, x, y, color, width){
    // console.log("если ты это видишь то ты умничка (да да я хвалю сам себя)")
    ctx.fillStyle = color;
    let xPoint = x*width/12 + width/2;
    let yPoint = -y*width/12+width/2;
    // console.log(xPoint + " " + yPoint + " " + width)
    ctx.beginPath();
    ctx.arc(xPoint, yPoint, 3, 0, Math.PI*2,false);
    ctx.closePath();
    ctx.fill();
}

const  mapStateToProps = store =>{
    return{
        page: store.page,
        style: store.style
    }
}

const mapDispatchToProps = dispatch =>{
    return{
        setMessageR: messageR => dispatch(setMessageR(messageR)),
        sendPoint: butch => dispatch(sendPoint(butch))
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Canvas)