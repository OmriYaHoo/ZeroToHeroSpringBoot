import React, {Component} from 'react';

export default class Header extends Component {
    render() {
        return (
            <section className="hero is-primary is-bold">
                <div className="hero-body">
                    <div className="container">
                        <h1 className="title">
                            <i className="fa fa-github-square" aria-hidden="true"/>&nbsp;Github Dashboard
                        </h1>
                    </div>
                </div>
            </section>
        );
    }
}
