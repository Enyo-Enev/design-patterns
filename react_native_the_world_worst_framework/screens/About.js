import React from 'react';
import { StyleSheet, Text, View} from 'react-native';

export default function About()
{
	return (
		<View style={styles.about}>
			<Text style={styles.text}>This is an application for redacting comments!</Text>
		</View>
	)
}

const styles = StyleSheet.create({
	about: {
		flex: 1,
		backgroundColor: '#B8B8B8'
	},
	text: {
		textAlign: 'left'
	}
})
