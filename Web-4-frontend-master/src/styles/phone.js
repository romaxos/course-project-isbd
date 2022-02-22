export const stylePhone = {
    header: {
        info: {
            width: '50%',
            textAlign: 'left',
            fontSize: '17px',           // was a 25px
            fontWeight: 'bold'
        },
        topic:{
            width: '50%',
            textAlign: 'right',
            fontSize: '17px',           // was a 40px
            fontWeight: 'bold'
        },
        table: {
            background: 'black',
            fontFamily: 'Arial',
            color: 'white'
        },
    },
    sign: {
        fontSize: '15pt',
        color: 'white',
        // position: 'absolute',
        // bottom: '0px',
        // right: '10px'
        marginRight: '10px'
    },
    clock:{
        // position: 'absolute',
        // left: '0px',
    },
    loginField: {
        align:{
            marginLeft: 'auto',
            marginRight: 'auto',
            width: '350px',
            // background: 'white',
            backgroundImage: "linear-gradient(#FFFFFF,#e0e0e0)",
            // position: 'absolute',
            // top: "900px",
            // bottom: '50px',
            // right: "25%",
            // left: '28%',
            focus: '',
            borderRadius: '20px'
        },
        login:{
            padding: '5px',
            textAlign: 'left',
            fontSize: '30px',
            backgroundImage: "linear-gradient(#cacaca,#b8b8b8)",

            fontFamily: 'Arial',
            // background: '#cacaca',
            color: 'black',
            borderRadius: '10px',
            borderWidth: '0px',
            width: '95%'
        },
        register: {
            padding: '5px',
            textAlign: 'left',
            fontFamily: 'Arial',
            fontSize: '30px',
            backgroundImage: "linear-gradient(#cacaca,#b8b8b8)",

            // background: '#cacaca',
            color: 'black',
            borderRadius: '10px',
            borderWidth: '0px',
            width: '95%'
        },
        userAnswer:{
            color: 'black',
            fontSize: '15pt',
            marginTop: '10pt',
            textAlign: 'left',
            marginLeft: '40pt'
        },
        loginButton: {
            fontSize: "20pt",
            backgroundImage: "linear-gradient(#1C1C1C,black)",
            color: "white",
            borderRadius: '15px',
            padding: "10pt 30pt",
            border:" grey 2pt",
            opacity: "0.8",
        },
        registerButton: {
            fontSize: "20pt",
            // background: "black",
            backgroundImage: "linear-gradient(#1C1C1C,black)",
            color: "white",
            padding: "10pt 20pt",
            borderRadius: '15px',
            border:" grey 2pt",
            opacity: "0.8",
        },
        tableBut: {
            padding: '10pt 10pt'
        }
    },canvas:{
        borderTop: '226px',
        borderRadius: '25px',
        // borderWidth: "3px",
        // borderStyle: 'solid',
        // borderImage : 'linear-gradient(#1c1c1c,black'
    },
    formView: {
        block:{                     // див для главного блока формы
            backgroundImage: "linear-gradient(#FFFFFF,#d6d6d6)",
            color: 'black',
            // width: '600px',
            marginLeft: '10%',
            marginRight: '10%',
            marginTop: '20pt',
            borderRadius: '30px',
        },
        label:{
            fontSize: '30px',
            marginLeft: '10px'
        },
        labelR: {
            fontSize: '40px',
            marginLeft: '10px'
        },
        pHeader:{
            float: 'left',
            margin: '1.5% 1.5%',
            width: '45%',
            fontSize: '30px'
        },
        logout: {
            fontSize: "18pt",
            float: 'right',
            margin: '1.5% 1.5%',
            marginRight: '20px',
            width: '40%',
            // background: "black",
            backgroundImage: "linear-gradient(#1C1C1C,black)",
            color: "white",
            padding: "5pt 10pt",
            borderRadius: '15px',
            border:" grey 2pt",
            opacity: "0.8",
        },
        message: {
            color: 'black'
        },
        xField: {           // див ввода X
            margin: '0% 0%',
            marginLeft: '200pt',
            width: '30%'
        },
        send: {
            fontSize: "20pt",
            // background: "black",
            backgroundImage: "linear-gradient(#1C1C1C,black)",
            color: "white",
            padding: "10pt 20pt",
            borderRadius: '15px',
            border:" grey 2pt",
            opacity: "0.8",
        },
        td: {
            paddingLeft: '10px',
            verticalAlign: 'top',
            textAlign: 'left',
        },
        fieldY: {
            padding: '5px',
            textAlign: 'left',
            fontSize: '10px',
            // width: '80%',
            backgroundImage: "linear-gradient(#cacaca,#b8b8b8)",

            fontFamily: 'Arial',
            // background: '#cacaca',
            color: 'black',
            borderRadius: '7px',
            borderWidth: '0px',
        },

        fieldX: {
            marginLeft: '0px',
            padding: '5px',
            textAlign: 'left',
            fontSize: '10px',

            backgroundImage: "linear-gradient(#cacaca,#b8b8b8)",

            fontFamily: 'Arial',
            // background: '#cacaca',
            color: 'black',
            borderRadius: '7px',
            borderWidth: '0px',


        },
        fieldR: {                   // input R
            marginLeft: '0px',
            padding: '5px',
            textAlign: 'left',
            fontSize: '10px',

            backgroundImage: "linear-gradient(#cacaca,#b8b8b8)",

            fontFamily: 'Arial',
            // background: '#cacaca',
            color: 'black',
            borderRadius: '7px',
            borderWidth: '0px',
        },
        rad:{
            // float: 'right',
            // margin: '0% 0%',
            // width: '30%'
            // marginLeft: '20pt',

        },
        lol:{
            // float: 'right',
            // margin: '0% 40%',
            // width: '30%',
            // marginLeft: '20pt',

        },
        divHeaderInForm: {
            height: "50px"
        },

        descriptionX: {
            marginTop: "20px" ,
            fontSize: '15px',
            textAlign: 'center',
            width: '100%'
        },
        descriptionR: {
            marginTop: "20px" ,
            fontSize: '15px',
            textAlign: 'center',
            width: '100%'
        },
        descriptionY: {
            marginTop: "20px" ,
            fontSize: '15px',
            textAlign: 'center',
            width: '100%'
        },
    },
    result:{
        block: {
            overflow: 'scroll',
            height: '80pt',
            // marginRight: 'auto',
            // marginLeft:'auto',
            // marginTop: '20%'
            borderRadius: '30px'
        },
        main:{
            overflow: 'scroll',
            height: '50pt',
            width: '90%',
            marginTop: '20px',
            textAlign: 'left',
            backgroundImage: 'linear-gradient(#cacaca,#b8b8b8)',
            padding: '10pt 10pt',
            marginLeft: 'auto' ,
            marginRight: 'auto',
            borderRadius: '15px',
            marginBottom: '30px'
        },
        header: {
            textAlign: 'center',
            fontSize: '20pt',
            backgroundImage: 'linear-gradient(#1C1C1C,black)',
            color: 'white',
            border:" grey 2pt",
            opacity: "0.8",
            borderRadius: '10px'
        },
        element: {
            textAlign: 'left',
            fontSize: '15pt',
            color: 'black'
        }

    }
}