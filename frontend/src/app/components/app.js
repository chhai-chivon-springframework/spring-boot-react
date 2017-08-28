import React from 'react';

import Header  from './header/Header';
import Footer from './footer/Footer';
export default class App extends React.Component {
    render() {
        return (
            <div>
                <div>
                    <Header />
                </div>
                <div className="container">
                    {this.props.children}
                </div>
                <div>
                    <Footer />
                </div>
            </div>
        );
    }
}



