import { createAppContainer } from 'react-navigation';
import { createDrawerNavigator } from 'react-navigation-drawer';

import HomeStack from './HomeStack';
import About from '../screens/About';

const MainDrawer = createDrawerNavigator({
	Home: {
		screen: HomeStack,
		navigationOptions : {
			title: 'Home'
		}
	},
	About: {
		screen: About,
		navigationOptions : {
			title: 'About'
		}
	}
});

export default createAppContainer(MainDrawer);
