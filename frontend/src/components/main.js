/**
 * Created by chhaichivon on 8/27/17.
 */

import React from 'react';

import Header from './layouts/header';
import Footer from './layouts/footer';

export default class Main extends React.Component{

    render(){
        return(
            <div>
                <div>
                    <Header/>
                </div>
                <div>
                        Hello
                </div>
                <div>
                    <Footer/>
                </div>
            </div>
        );
    }
}