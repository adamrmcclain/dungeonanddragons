var mongoose = require('mongoose');

var MonsterSchema = new mongoose.Schema({

			MonsterName: {type: String, required: true},
			Size: String,
			Race: String,
			Alignment: String,
			ArmorClass: String,
			HitPoints: String,
			Speed: String,
			Stats: {
				Strength: String,
				Dexterity: String,
				Constitution: String,
				Intelligence: String,
				Wisdom: String,
				Charisma: String
			},
			SavingThrows: [String],
			Skills: [String],
			DamageImmunities : [String],
			DamageResistances : [String],
			ConditionImmunities : [String],
			Senses: [String],
			Languages: [String],
			Challenge: String,
			Experience : String,
			Actions : [String],
			LegendaryActions : [String],
			Reactions : [String],
			AdditionalInformation : [String]
});

module.exports = mongoose.model('Monster', MonsterSchema);