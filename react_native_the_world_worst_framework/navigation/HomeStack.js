import Home from '../screens/Home';
import RedactComment from '../screens/RedactComment';
import { createStackNavigator } from 'react-navigation-stack';

const screens = {
	Home: {
		screen: Home,
		navigationOptions : {
			title: 'Home'
		}
	},
	Redact: {
		screen: RedactComment,
		navigationOptions : {
			title: 'Redact'
		}
	}
}

const HomeStack = createStackNavigator(screens);
export default HomeStack;
