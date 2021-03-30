import React from 'react';
import '../style/public.css';
import '../style/searchpage.css'
import seratchLogo from '../img/seratch.png'

export class Search extends React.Component{
    render(){
        return(
            <div className = "search_page">
                <div className = "search_logo">
                    <img src={seratchLogo} alt=""/>
                </div>
                <div className = "search_input_warp">
                    <input className = "search_input"></input>
                        <div>
                            <a className = "serach_button" href = "#">搜索素材</a>
                        </div>
                </div>
            </div>
        )
    }
}
export default Search;