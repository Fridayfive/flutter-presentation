import React from 'react';
import ReactDOM from 'react-dom';
import './style/index.css';
import './style/Title.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
// import TitleViwe from './coms/titleView'
// import Search from './coms/Search'
// import Showitem from './coms/Showitem'




ReactDOM.render( < App / > , document.getElementById('root'));


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();