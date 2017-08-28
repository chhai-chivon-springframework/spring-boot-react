import React from "react";
import {Router, Route, IndexRoute} from "react-router";
import {history} from "./store.js";
import App from './app/components/app';


/*Home Page*/
import Index from './app/components/body/Index';

const router = (
    <Router  history={history}>
        <Route path="/" component={App}>
            <IndexRoute component={Index}/>
        </Route>
    </Router>
);
export {router};