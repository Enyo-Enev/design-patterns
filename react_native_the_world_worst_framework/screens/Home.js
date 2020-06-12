import React, { useState } from 'react';
import { AppLoading } from 'expo';
import { StyleSheet, Text, View, FlatList, TouchableOpacity } from 'react-native';

export default function Home({ navigation }) {
	const [loaded, setLoaded] = useState(false);
	const [comments, setComments] = useState([]);

	const getCommentsData = () => {
		var baseURL = 'https://jsonplaceholder.typicode.com';
		var url = baseURL + '/posts/1/comments';

		/* Some ridiculous CORS warning 
		var myHeaders = new Headers();
		myHeaders.append('Accept', 'application/json');
		myHeaders.append('Content-Type', 'application/json');

		var myMethod = {
			method: 'GET',
			dataType: 'json',
			headers: myHeaders
		}
		*/

		//NOTE(enev): WELCOME TO THE WORLD'S WORST FRAMEWORK HELL YEA!
		//
		//NOTE(enev): If you try to make this function out of scope of this "component" then you cant use 
		//setComments. Ok! But the result of the func how the heck 
		//do I take it if i just return response; onFinish={(???what???) => {setLoaded(true); setComments(??what??)}}
		//A Promise??? It didnt a work for some reason! Then what onFinish={promise??.resolve()???}
		//
		//and if by accident you type var Promise = new Promise(blah... hell breaks loose cuz nobody can tell u
		//that there a global named the same way and u overwrite it! That's completely fine OMG!
		//
		//field in renderItem={({item})} THIS HAS TO SPECIFICALLY BE CALLED ITEM WHEN DESTRUCTURING :D FOR SOME REASON
		//
		fetch(url)
			.then((response) => response.json())
			.then((response) => {console.log(response);
			return setComments(response);})
			.catch((error) => {console.error(error)})
	}

	if(loaded)
	{
		return (
			<View style={styles.container}>
			<FlatList data={comments}
				keyExtractor={(comments) => comments.id.toString()}
				renderItem={({item}) => (
				<TouchableOpacity style={styles.properties} onPress={() => navigation.push('Redact', item)}>
					<Text style={styles.commentBody}> Name: {item.name} </Text>
					<Text style={styles.commentBody}> Email: {item.email} </Text>
					<Text style={styles.commentBody}> Body: {item.body} </Text>
				</TouchableOpacity>
			)}/>
			</View>
		)
	}
	else
	{
		return (
			<AppLoading startAsync={getCommentsData} onError={console.warn} onFinish={() => {setLoaded(true);}}/>
		)
	}
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		backgroundColor: '#fff',
		paddingTop: 40,
		paddingHorizontal: 20,
	},
	properties: {
		flexDirection: 'column',
		borderWidth: 1,
		marginVertical: 10,
	},
	commentBody: {
		padding: 5,
		color: 'black',
		backgroundColor: 'pink',
		fontSize: 15,
		marginHorizontal: 10,
		marginVertical: 10,
	}
});
