import React from 'react';
import '../style/Title.css'
import '../style/public.css'
import logo from '../img/logopix.png'

export class TitleViwe extends React.Component{ 
  constructor(props){
    super(props)
    // console.log() 
  }


  getScreenSize=()=>{
   console.log(document.querySelector('body').offsetWidth) 
  }
 

  
  render(){
      return(
        <div className = "title">
          <div className = "title_land">
            <div className = "icon"><a href="#"><span>Pixel</span></a><img  src = {logo}></img>
            </div>
            <nav>
              <ul className = "clearfix">
                <li className = "nav_item"><a href=""><span>首页</span></a></li>
                <li className = "nav_item_drop-down"><a href=""><span>3D素材</span><DropDown></DropDown></a></li>
                <li className = "nav_item_drop-down"><a href=""><span>2.5D素材</span><DropDown></DropDown></a></li>
                <li className = "nav_item_drop-down"><a href=""><span>2D素材</span><DropDown></DropDown></a></li>
                <li className = "nav_item"><a href=""><span>Icon</span></a></li>
              </ul>
            </nav>
            <div className = "menu">
              <ul>
                <li><a href = "#"><spam>用户</spam></a></li>
                <li><a href = "#"><spam>上传</spam></a></li>
                <li><a href = "#"><spam>设置</spam></a></li>
              </ul>
            </div>
          </div>
        </div>
      )
    }
  }

export class DropDown extends React.Component{
  render(){
    return(
      <ul className="drop-down-content">
        <li><a href="#">di</a></li>
        <li><a href="#">我是2</a></li>
        <li><a href="#">我是3</a></li>
      </ul>
    )
  }
}


export default TitleViwe;