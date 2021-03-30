import React from 'react';
import '../style/Showitem.css';
import seratchLogo from '../img/seratch.png'


export class Showitem extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            imgList: [
                {
                userIcon : seratchLogo,
                userName: "Mr.Wu",
                thumbnail: seratchLogo,
                url: "#"
                }
        ]
        }
    }

    componentDidMount() {
        
    }

    render() {
        return (
            <a className="show_item_card">
                <div className="author_icon">
                    <img src={seratchLogo}></img>
                </div>
                <div className="author_name">
                    <span>Mr.Wu</span>
                </div>
                <div className="img_preview">
                    <ul>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                        <li><img src={seratchLogo}></img></li>
                    </ul>
                </div>
            </a>
        )
    }
}

export default Showitem;