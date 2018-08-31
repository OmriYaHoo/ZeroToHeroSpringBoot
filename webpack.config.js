const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: './src/main/resources/static/js/index.js',
    // devtool: 'sourcemaps',
    // cache: true,
    // debug: true,
    output: {
        path: path.join(__dirname, '/src/main/resources/static/dist'),
        filename: 'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: 'src/main/resources/templates/index.html'
        })
    ]
};
