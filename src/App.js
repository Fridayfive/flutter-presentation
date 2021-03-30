import React from 'react';
// import logo from './img/logo.svg';
import './style/App.css';
import TitleViwe from './coms/titleView'
import Search from './coms/Search'
import Showitem from './coms/Showitem'
import PageBottom from './coms/pagebottom'

export class App extends React.Component{
  
  
  render(){  
    return (
    <div className="App">
      <TitleViwe></TitleViwe>
      <Search></Search>
      <div className = "show_page">
        <Showitem></Showitem>
        <Showitem></Showitem>
        <Showitem></Showitem>
        <Showitem></Showitem>
      </div>
      <PageBottom></PageBottom>
    </div>
  );
}
}



export default App;
