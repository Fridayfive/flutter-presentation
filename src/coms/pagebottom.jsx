import React from 'react';
import seratchLogo from '../img/seratch.png'
import '../style/pageBottom.css'

export class PageBottom extends React.Component{
    render(){
        return(
            <div className = "page_bottom">
               <div>     
                        <img src = {seratchLogo}></img>
                        <div><span>此网站为广大体素爱好者提供模型参考</span></div>
                        <div><span>设计师将模型上传到Iconfont平台，用户可以自定义下载多种样式模型，便于个人开发者使用。</span></div>            
                        <br></br>
                        <div><span>微信公众平台</span></div>
                        <img src = {seratchLogo}></img>
                  
                </div>
            </div>
        )
    }
}

export default PageBottom